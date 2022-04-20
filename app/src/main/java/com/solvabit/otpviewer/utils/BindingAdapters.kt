package com.solvabit.otpviewer.utils

import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.solvabit.otpviewer.R
import com.solvabit.otpviewer.model.Message
import com.solvabit.otpviewer.ui.home.HomeAdapter
import java.util.*

@BindingAdapter("bindAllSenders")
fun bindAllSenders(recyclerView: RecyclerView, data: List<Message>?) {
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}

@BindingAdapter("bindSenderImage")
fun bindSenderImage(imageView: ImageView, message: Message?) {
    message?.let {
        imageView.setImageResource(R.drawable.account_default_icon)
        imageView.setColorFilter(getColor(message.address))
    }
}

fun getColor(string: String): Int {
    val rnd = Random()
    return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}

@BindingAdapter("bindTextColor")
fun bindTextColor(textView: TextView, int: Int?) {
    int?.let {
        when(it) {
            0 -> {
                textView.setTextColor(Color.parseColor("#000000"))

            }
            else -> {
                textView.setTextColor(Color.parseColor("#99000000"))

            }
        }
    }
}

@BindingAdapter("bindFormatDate")
fun bindDate(textView: TextView, date: Long?) {
    date?.let {
        val messageDate = Date(date).toString()
        val todayDate = Calendar.getInstance().time.toString()

        if(messageDate.substring(0, 10) == todayDate.substring(0, 10))
            textView.text = messageDate.substring(11, 16)
        else
            textView.text = messageDate.substring(4, 10)


    }
}