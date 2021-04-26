package com.example.mycalendarapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applandeo.materialcalendarview.EventDay
import com.example.mycalendarapp.databinding.ActivityMainBinding
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

private const val INTENT_EVENT_ID = "INTENT_EVENT_ID"

class MainActivity : AppCompatActivity() , DayHoursAdapter.OnEventClickListener{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calendarView.setDate(Calendar.getInstance())
        binding.calendarView.setOnDayClickListener { eventDay -> previewNote(eventDay) }
        binding.calendarView.setEvents(EventsProvider.eventCalendar)
        binding.title.text = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Calendar.getInstance().time)
        binding.rcDayHours.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcDayHours.adapter=DayHoursAdapter(DayProvider(Timestamp(Calendar.getInstance().timeInMillis)).getHours(), this)
        binding.fabCreate.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun previewNote(eventDay: EventDay) {
        binding.title.text = SimpleDateFormat("d MMMM yyyy", Locale.getDefault()).format(eventDay.calendar.time)
        binding.rcDayHours.adapter = DayHoursAdapter(
            DayProvider(Timestamp(eventDay.calendar.timeInMillis)).getHours(),
            this
        )
    }

    override fun onEventClick(id: Int) {
        val intent = Intent(this, EventActivity::class.java)
        intent.putExtra(INTENT_EVENT_ID, id)
        startActivity(intent)
    }

}
