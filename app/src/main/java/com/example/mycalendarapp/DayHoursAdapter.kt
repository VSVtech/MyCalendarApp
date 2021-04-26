package com.example.mycalendarapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalendarapp.databinding.RcDayBinding
import com.google.android.material.chip.Chip
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


class DayHour(val hour: Timestamp){
    val end = Timestamp(hour.time + 3600 * 1000)
    var events = mutableListOf<Event>()
}


class DayHoursAdapter(private val list: List<DayHour>, var onEventClickListener: OnEventClickListener)
    : RecyclerView.Adapter<DayHoursAdapter.DayHourHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DayHourHolder(RcDayBinding.inflate(LayoutInflater.from(parent.context)),onEventClickListener)

    override fun onBindViewHolder(holder: DayHourHolder, position: Int) {
        val dayHour: DayHour = list[position]
        holder.bind(dayHour)
    }

    override fun getItemCount(): Int = list.size

    class DayHourHolder(private val binding: RcDayBinding, private var eventClickListener: OnEventClickListener) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(dayHour: DayHour) {
            binding.rcTitle.text= "${SimpleDateFormat("HH:mm", Locale.getDefault()).format(dayHour.hour)} - ${SimpleDateFormat("HH:mm", Locale.getDefault()).format(dayHour.end)}"
            binding.rcChiplist.removeAllViews()
            binding.rcChiplist.invalidate()
            for (event in dayHour.events) {
                val chip = Chip(itemView.context)
                val startTimeString = SimpleDateFormat("H:mm", Locale.getDefault()).format(event.date_start).toString()
                val finishTimeString = SimpleDateFormat("H:mm", Locale.getDefault()).format(event.date_finish) .toString()
                chip.text = "$startTimeString-$finishTimeString: ${event.name}"
                //TODO: implement better id assignment
                chip.id=event.id
                chip.setOnClickListener(this)
                //chip.setTextColor(itemView.context.resources.getColor(R.color.purple_200,itemView.context.theme))
                binding.rcChiplist.addView(chip)
            }
        }

        override fun onClick(v: View?) {
             v?.id?.let {
                 if (EventsProvider.findEvent(it) != null) eventClickListener.onEventClick(it)
             }
        }
    }
    interface OnEventClickListener{
        fun onEventClick(id:Int)
    }
}