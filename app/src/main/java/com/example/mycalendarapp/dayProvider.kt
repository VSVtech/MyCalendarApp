package com.example.mycalendarapp

import com.applandeo.materialcalendarview.EventDay
import java.sql.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import java.util.*

object TimeStampAsLongSerializer : KSerializer<Timestamp> {
    override val descriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.LONG)
    override fun serialize(encoder: Encoder, value: Timestamp) = encoder.encodeLong(value.time)
    override fun deserialize(decoder: Decoder) = Timestamp(decoder.decodeLong())
}

@Serializable
class Event(
        val id:Int,
        @Serializable(with = TimeStampAsLongSerializer::class)
        val date_start:Timestamp,
        @Serializable(with = TimeStampAsLongSerializer::class)
        val date_finish:Timestamp,
        val name:String,
        val description:String = "")

object EventsProvider{
    var NextID=0
    var eventCalendar= mutableListOf<EventDay>()
    var eventList=mutableListOf<Event>()
    init{
        addEvent(
            Json.decodeFromString(
                Event.serializer(),
                """{
                        "id":0,
                        "date_start":"1619271000000",
                        "date_finish":"1619274600000"
                        "name":"Meeting",
                        "description":"Описание моего дела"
                        }"""))
        addEvent(
            Json.decodeFromString(
                Event.serializer(),
                """{
                        "id":1,
                        "date_start":"1619271000000",
                        "date_finish":"1619274600000"
                        "name":"Lecture",
                        "description":"Узнать, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что существует 2 типа людей: те, кто не знают что такое рекурсия, и те, кто знают, что "
                        }"""))
        addEvent(
            Json.decodeFromString(
                Event.serializer(),
                """{
                        "id":2,
                        "date_start":"1619514000000",
                        "date_finish":"1619521200000"
                        "name":"Отправить задание",
                        "description":"Крайний срок подачи тестового задания"
                        }"""))
    }
    fun findEvent(id:Int) = eventList.find { it.id == id }
    fun addEvent(event: Event) {
        eventList.add(event)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis=event.date_start.time
        eventCalendar.add(EventDay(calendar,R.drawable.calendar_event_icon))
        NextID++
    }
}
class DayProvider(dayStart:Timestamp) {

    private var dayHours = listOf(
        DayHour(Timestamp(dayStart.time + 0*3600*1000)),
        DayHour(Timestamp(dayStart.time + 1*3600*1000)),
        DayHour(Timestamp(dayStart.time + 2*3600*1000)),
        DayHour(Timestamp(dayStart.time + 3*3600*1000)),
        DayHour(Timestamp(dayStart.time + 4*3600*1000)),
        DayHour(Timestamp(dayStart.time + 5*3600*1000)),
        DayHour(Timestamp(dayStart.time + 6*3600*1000)),
        DayHour(Timestamp(dayStart.time + 7*3600*1000)),
        DayHour(Timestamp(dayStart.time + 8*3600*1000)),
        DayHour(Timestamp(dayStart.time + 9*3600*1000)),
        DayHour(Timestamp(dayStart.time +10*3600*1000)),
        DayHour(Timestamp(dayStart.time +11*3600*1000)),
        DayHour(Timestamp(dayStart.time +12*3600*1000)),
        DayHour(Timestamp(dayStart.time +13*3600*1000)),
        DayHour(Timestamp(dayStart.time +14*3600*1000)),
        DayHour(Timestamp(dayStart.time +15*3600*1000)),
        DayHour(Timestamp(dayStart.time +16*3600*1000)),
        DayHour(Timestamp(dayStart.time +17*3600*1000)),
        DayHour(Timestamp(dayStart.time +18*3600*1000)),
        DayHour(Timestamp(dayStart.time +19*3600*1000)),
        DayHour(Timestamp(dayStart.time +20*3600*1000)),
        DayHour(Timestamp(dayStart.time +21*3600*1000)),
        DayHour(Timestamp(dayStart.time +22*3600*1000)),
        DayHour(Timestamp(dayStart.time +23*3600*1000)))

    init {
        for (hour in dayHours)
            for (event in EventsProvider.eventList)
                if(event.date_start.before(hour.end) && event.date_finish.after(hour.hour))
                    hour.events.add(event)
    }

    fun getHours() = dayHours
}