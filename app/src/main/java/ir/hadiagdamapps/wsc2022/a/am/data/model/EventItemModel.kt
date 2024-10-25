package ir.hadiagdamapps.wsc2022.a.am.data.model

data class EventItemModel(
    val id: Int,
    val title: String,
    val viewCount: Int,
    val pictures: List<String>,
    val text: String,
    val read: Boolean
)