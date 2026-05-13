package com.example.llmchatbot.ui.chat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.llmchatbot.data.db.Message
import com.example.llmchatbot.databinding.ItemMessageReceivedBinding
import com.example.llmchatbot.databinding.ItemMessageSentBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
class ChatAdapter(
    private val userInitial: String
) : ListAdapter<Message, RecyclerView.ViewHolder>(MessageDiffCallback()) {
    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
        private val TIME_FORMAT = SimpleDateFormat("h:mm a", Locale.getDefault())
    }
    override fun getItemViewType(position: Int): Int =
        if (getItem(position).isFromUser) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_SENT) {
            SentViewHolder(ItemMessageSentBinding.inflate(inflater, parent, false))
        } else {
            ReceivedViewHolder(ItemMessageReceivedBinding.inflate(inflater, parent, false))
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = getItem(position)
        val timeString = TIME_FORMAT.format(Date(message.timestamp))
        when (holder) {
            is SentViewHolder -> holder.bind(message.content, timeString)
            is ReceivedViewHolder -> holder.bind(message.content, timeString)
        }
    }
    inner class SentViewHolder(
        private val binding: ItemMessageSentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String, time: String) {
            binding.tvMessage.text = text
            binding.tvTimestamp.text = time
            binding.ivUserAvatar.text = userInitial
        }
    }
    inner class ReceivedViewHolder(
        private val binding: ItemMessageReceivedBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String, time: String) {
            binding.tvMessage.text = text
            binding.tvTimestamp.text = time
        }
    }
    private class MessageDiffCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean =
            oldItem == newItem
    }
}
