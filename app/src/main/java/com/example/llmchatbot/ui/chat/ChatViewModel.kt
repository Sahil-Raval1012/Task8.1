package com.example.llmchatbot.ui.chat
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.llmchatbot.R
import com.example.llmchatbot.data.db.AppDatabase
import com.example.llmchatbot.data.db.Message
import com.example.llmchatbot.network.GroqApiService
import com.example.llmchatbot.network.GroqMessage
import com.example.llmchatbot.network.GroqRequest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
class ChatViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getInstance(application).messageDao()
    private val api = GroqApiService.create()
    private val apiKey = application.getString(R.string.groq_api_key)
    private val _messages = MutableLiveData<List<Message>>(emptyList())
    val messages: LiveData<List<Message>> = _messages
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    private var sessionId: String = ""
    fun init(username: String) {
        sessionId = username
        viewModelScope.launch {
            dao.getMessagesForSession(sessionId).collectLatest { list ->
                _messages.postValue(list)
            }
        }
    }
    fun sendWelcomeMessage(username: String) {
        viewModelScope.launch {
            val existing = dao.getMessagesForSessionOnce(sessionId)
            if (existing.isEmpty()) {
                val welcome = Message(
                    sessionId = sessionId,
                    content = "Welcome $username! How can I help you today?",
                    isFromUser = false
                )
                dao.insertMessage(welcome)
            }
        }
    }
    fun sendMessage(userText: String) {
        if (userText.isBlank()) return
        viewModelScope.launch {
            _isLoading.postValue(true)
            _error.postValue(null)
            val userMessage = Message(
                sessionId = sessionId,
                content = userText,
                isFromUser = true
            )
            dao.insertMessage(userMessage)
            try {
                val history = dao.getMessagesForSessionOnce(sessionId)
                val messages = history
                    .dropWhile { !it.isFromUser }
                    .map { msg ->
                        GroqMessage(
                            role = if (msg.isFromUser) "user" else "assistant",
                            content = msg.content
                        )
                    }
                val response = api.chatCompletion(
                    authorization = "Bearer $apiKey",
                    request = GroqRequest(
                        model = "llama-3.1-8b-instant",
                        messages = messages
                    )
                )
                if (response.isSuccessful) {
                    val replyText = response.body()
                        ?.choices
                        ?.firstOrNull()
                        ?.message
                        ?.content
                        ?: "Sorry, I didn't get your message."
                    val botMessage = Message(
                        sessionId = sessionId,
                        content = replyText,
                        isFromUser = false
                    )
                    dao.insertMessage(botMessage)
                } else {
                    _error.postValue(
                        getApplication<Application>().getString(R.string.error_api)
                    )
                }
            } catch (e: Exception) {
                _error.postValue(
                    getApplication<Application>().getString(R.string.error_api)
                )
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}
