package com.example.mycalendarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applandeo.materialcalendarview.*
import com.applandeo.materialcalendarview.builders.DatePickerBuilder
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener
import com.example.mycalendarapp.databinding.ActivityCreateBinding
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CreateActivity : AppCompatActivity(), OnSelectDateListener {

    private lateinit var binding: ActivityCreateBinding

    var calendarSelector = 0
    var startDay = Calendar.getInstance()
    var finishDay = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.createTitle)
        binding.createStartDate.setText(SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Calendar.getInstance().time).toString())
        binding.createStartTime.setIs24HourView(true)
        binding.createStartTime.hour=Calendar.getInstance().get(Calendar.HOUR)
        binding.createStartTime.minute=Calendar.getInstance().get(Calendar.MINUTE)
        binding.createFinishDate.setText(SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Calendar.getInstance().time).toString())
        binding.createFinishTime.setIs24HourView(true)
        binding.createFinishTime.hour=Calendar.getInstance().get(Calendar.HOUR)
        binding.createFinishTime.minute=Calendar.getInstance().get(Calendar.MINUTE)
        binding.createStartDate.setOnClickListener {
            calendarSelector = 0
            DatePickerBuilder(this,this)
                .pickerType(CalendarView.ONE_DAY_PICKER)
                .date(Calendar.getInstance())
                .headerColor(R.color.purple_200)
                .selectionColor(R.color.purple_200)
                .todayLabelColor(R.color.purple_700)
                .selectionLabelColor(R.color.purple_500)
                .build()
                .show()
        }
        binding.createFinishDate.setOnClickListener {
            calendarSelector = 1
            DatePickerBuilder(this,this)
                .pickerType(CalendarView.ONE_DAY_PICKER)
                .date(Calendar.getInstance())
                .headerColor(R.color.purple_200)
                .selectionColor(R.color.purple_200)
                .todayLabelColor(R.color.purple_700)
                .selectionLabelColor(R.color.purple_500)
                .build()
                .show()
        }
        binding.createCreate.setOnClickListener {
            startDay.set(Calendar.HOUR,binding.createStartTime.hour)
            startDay.set(Calendar.MINUTE,binding.createStartTime.minute)
            finishDay.set(Calendar.HOUR,binding.createFinishTime.hour)
            finishDay.set(Calendar.MINUTE,binding.createFinishTime.minute)
            EventsProvider.addEvent(
                    Event(
                            EventsProvider.NextID,
                            Timestamp(startDay.timeInMillis),
                            Timestamp(finishDay.timeInMillis),
                            binding.createName.text.toString(),
                            binding.createDescription.text.toString()))
            finish()
        }

    }

    override fun onSelect(calendar: MutableList<Calendar>?) {
        if (calendarSelector == 0) {
            if (calendar?.size == 1) {
                binding.createStartDate.setText(
                    SimpleDateFormat(
                        "dd MMMM yyyy",
                        Locale.getDefault()
                    ).format(calendar[0].time).toString()
                )
                startDay = calendar[0]
            }
        }
        else
            if (calendar?.size==1) {
                binding.createFinishDate.setText(
                    SimpleDateFormat(
                        "dd MMMM yyyy",
                        Locale.getDefault()
                    ).format(calendar[0].time).toString()
                )
                finishDay = calendar[0]
            }
    }

}