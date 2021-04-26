package com.example.mycalendarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycalendarapp.databinding.ActivityEventBinding
import java.text.SimpleDateFormat
import java.util.*

private const val INTENT_EVENT_ID = "INTENT_EVENT_ID"
class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(INTENT_EVENT_ID,-1)
        val event = EventsProvider.findEvent(id)
        event?.let {
            binding.eventName.text = it.name
            binding.eventStartTime.text = SimpleDateFormat("dd MMMM yyyy - HH:mm", Locale.getDefault()).format( it.date_start.time)
            binding.eventFinishTime.text = SimpleDateFormat("dd MMMM yyyy - HH:mm", Locale.getDefault()).format( it.date_finish.time)
            binding.eventDescription.text=it.description
        }
    }
}