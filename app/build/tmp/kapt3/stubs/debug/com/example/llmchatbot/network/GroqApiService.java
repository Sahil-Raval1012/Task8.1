package com.example.llmchatbot.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/llmchatbot/network/GroqApiService;", "", "chatCompletion", "Lretrofit2/Response;", "Lcom/example/llmchatbot/network/GroqResponse;", "authorization", "", "request", "Lcom/example/llmchatbot/network/GroqRequest;", "(Ljava/lang/String;Lcom/example/llmchatbot/network/GroqRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface GroqApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.llmchatbot.network.GroqApiService.Companion Companion = null;
    
    @retrofit2.http.POST(value = "openai/v1/chat/completions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object chatCompletion(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.llmchatbot.network.GroqRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.llmchatbot.network.GroqResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/llmchatbot/network/GroqApiService$Companion;", "", "()V", "BASE_URL", "", "create", "Lcom/example/llmchatbot/network/GroqApiService;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String BASE_URL = "https://api.groq.com/";
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.llmchatbot.network.GroqApiService create() {
            return null;
        }
    }
}