package ir.hadiagdamapps.wsc2022.a.am.data.database

import android.content.Context
import android.content.Context.MODE_PRIVATE

class EventsData(private val context: Context) {

    fun getViewCount() =
        HashMap<Int, Int>().apply {
            context.getSharedPreferences("view_count", MODE_PRIVATE).apply {
                this.all.forEach {
                    put(it.key.toInt(), it.value.toString().toInt())
                }
            }
        }

    fun updateViewCount(id: Int, viewCount: Int) {
        context.getSharedPreferences("view_count", MODE_PRIVATE).edit().apply {
            putInt(id.toString(), viewCount)
            apply()
        }
    }


}