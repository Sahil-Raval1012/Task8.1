package com.example.llmchatbot.ui.chat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/example/llmchatbot/ui/chat/ChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/llmchatbot/ui/chat/ChatAdapter;", "binding", "Lcom/example/llmchatbot/databinding/ActivityChatBinding;", "username", "", "viewModel", "Lcom/example/llmchatbot/ui/chat/ChatViewModel;", "getViewModel", "()Lcom/example/llmchatbot/ui/chat/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dispatchMessage", "", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupInput", "setupRecyclerView", "Companion", "app_debug"})
public final class ChatActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_USERNAME = "extra_username";
    private com.example.llmchatbot.databinding.ActivityChatBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.llmchatbot.ui.chat.ChatAdapter adapter;
    private java.lang.String username;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.llmchatbot.ui.chat.ChatActivity.Companion Companion = null;
    
    public ChatActivity() {
        super();
    }
    
    private final com.example.llmchatbot.ui.chat.ChatViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupInput() {
    }
    
    private final void dispatchMessage() {
    }
    
    private final void observeViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/llmchatbot/ui/chat/ChatActivity$Companion;", "", "()V", "EXTRA_USERNAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}