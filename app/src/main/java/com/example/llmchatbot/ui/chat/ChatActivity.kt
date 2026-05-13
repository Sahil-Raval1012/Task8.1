package com.example.llmchatbot.ui.chat
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.llmchatbot.databinding.ActivityChatBinding
class ChatActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModels()
    private lateinit var adapter: ChatAdapter
    private lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        username = intent.getStringExtra(EXTRA_USERNAME) ?: "User"
        setupRecyclerView()
        setupInput()
        observeViewModel()
        viewModel.init(username)
        viewModel.sendWelcomeMessage(username)
    }
    private fun setupRecyclerView() {
        val userInitial = username.firstOrNull()?.uppercaseChar()?.toString() ?: "U"
        adapter = ChatAdapter(userInitial)

        val layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true
        }
        binding.rvMessages.apply {
            this.layoutManager = layoutManager
            this.adapter = this@ChatActivity.adapter
            itemAnimator = null
        }
    }
    private fun setupInput() {
        binding.btnSend.setOnClickListener {
            dispatchMessage()
        }
        binding.etMessage.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                dispatchMessage()
                true
            } else {
                false
            }
        }
    }
    private fun dispatchMessage() {
        val text = binding.etMessage.text.toString().trim()
        if (text.isEmpty()) return
        binding.etMessage.setText("")
        viewModel.sendMessage(text)
    }
    private fun observeViewModel() {
        viewModel.messages.observe(this) { messages ->
            adapter.submitList(messages) {
                if (messages.isNotEmpty()) {
                    binding.rvMessages.scrollToPosition(messages.size - 1)
                }
            }
        }
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnSend.isEnabled = !isLoading
            binding.etMessage.isEnabled = !isLoading
        }
        viewModel.error.observe(this) { error ->
            if (!error.isNullOrEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }
    }
}
