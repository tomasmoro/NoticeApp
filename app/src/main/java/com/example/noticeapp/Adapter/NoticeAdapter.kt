package com.example.noticeapp.Adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noticeapp.R
import com.example.noticeapp.databinding.NoticeCardBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.notice_card.view.*

class NoticeAdapter(val notices: List<Notice>) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.notice_card, parent, false)
        return NoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val notice: Notice = notices.get(position)
        holder.bind(notice)
    }

    override fun getItemCount(): Int {
        return notices.size
    }

    class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = NoticeCardBinding.bind(itemView)

        fun bind(notice: Notice) {
            Picasso.get().load(notice.url).into(binding.ivNoticeCard)
            binding.tvCardNoticeTitle.setText(notice.title)
        }
    }

}