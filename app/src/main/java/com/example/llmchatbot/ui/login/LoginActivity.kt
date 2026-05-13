package com.example.llmchatbot.ui.login
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.llmchatbot.R
import com.example.llmchatbot.databinding.ActivityLoginBinding
import com.example.llmchatbot.ui.chat.ChatActivity
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etUsername.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                attemptLogin()
                true
            } else {
                false
            }
        }
        binding.btnGo.setOnClickListener {
            attemptLogin()
        }
    }
    private fun attemptLogin() {
        val username = binding.etUsername.text.toString().trim()
        if (username.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_username), Toast.LENGTH_SHORT).show()
            binding.etUsername.requestFocus()
            return
        }
        val intent = Intent(this, ChatActivity::class.java).apply {
            putExtra(ChatActivity.EXTRA_USERNAME, username)
        }
        startActivity(intent)
    }
}
