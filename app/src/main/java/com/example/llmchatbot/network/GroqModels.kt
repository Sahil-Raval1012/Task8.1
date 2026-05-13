package com.example.llmchatbot.network
data class GroqRequest(
    val model: String,
    val messages: List<GroqMessage>,
    val temperature: Double = 0.7,
    val max_tokens: Int = 1024
)
data class GroqMessage(
    val role: String,
    val content: String
)
data class GroqResponse(
    val choices: List<GroqChoice>?
)
data class GroqChoice(
    val message: GroqMessage?
)
