package ir.hadiagdamapps.wsc2022.a.am.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import ir.hadiagdamapps.wsc2022.a.am.data.database.EventsData
import ir.hadiagdamapps.wsc2022.a.am.data.model.EventItemModel
import okio.use
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream

class EventScreenViewModel(
    private val itemClick: (EventItemModel) -> Unit,
    context: Context

) : ViewModel() {

    var selectedTab: Int by mutableIntStateOf(0)
        private set

    private var loadedEvents: ArrayList<EventItemModel> = arrayListOf()
    private val _events = mutableStateListOf<EventItemModel>()
    val events: SnapshotStateList<EventItemModel> = _events

    private val eventsData = EventsData(context)
    private val eventsInputStream = context.assets.open("events.json")

    private var currentFilter: Int = 0


    init {
        loadEvents()
        filterEvents()
    }

    private fun loadEvents() {
        val jsonContent =
            JSONArray(eventsInputStream.bufferedReader().use(BufferedReader::readText))

        val viewCount: HashMap<Int, Int> = eventsData.getViewCount()

        val list = ArrayList<EventItemModel>()
        for (i in 0 until jsonContent.length()) {
            val obj = jsonContent.getJSONObject(i)
            list.add(
                EventItemModel(
                    id = obj.getInt("id"),
                    title = obj.getString("title"),
                    viewCount = viewCount[obj.getInt(
                        "id"
                    )] ?: obj.getInt("view_count"),
                    pictures = ArrayList<String>().apply {
                        obj.getJSONArray("pictures").forEachString {
                            add(it)
                        }
                    },
                    text = obj.getString("text"),
                    read = obj.getBoolean("read") || viewCount.keys.contains(obj.getInt("id"))

                )
            )
        }
        loadedEvents = list
    }

    private fun filterEvents() {
        _events.clear()



        when (currentFilter) {
            0 ->
                for (e in loadedEvents)
                    _events.add(e)

            1 ->
                for (e in loadedEvents)
                    if (!e.read) _events.add(e)

            2 ->
                for (e in loadedEvents)
                    if (e.read) _events.add(e)

        }

    }

    fun tabChanged(i: Int) {
        if (i < 3) {
            selectedTab = i
            currentFilter = i
            filterEvents()
        }
    }

    fun eventClick(eventModel: EventItemModel) {

        val index = loadedEvents.indexOfFirst { it.id == eventModel.id }

        if (index >= 0) {
            val viewCount = loadedEvents[index].viewCount + 1

            loadedEvents[index] = loadedEvents[index].copy(viewCount = viewCount, read = true)
            eventsData.updateViewCount(index, viewCount)

            filterEvents()
            itemClick(eventModel)
        }
    }

}

fun JSONArray.forEachString(item: (String) -> Unit) {
    for (i in 0 until length())
        item(getString(i))
}
