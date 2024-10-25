package ir.hadiagdamapps.wsc2022.a.am.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import ir.hadiagdamapps.wsc2022.a.am.ui.theme.Typography

@Composable
fun EventItem(
    modifier: Modifier = Modifier,
    url: String,
    title: String,
    previewText: String,
    read: Boolean,
    onClick: () -> Unit
) {


    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .height(100.dp)
            .padding(vertical = 7.dp)
    ) {


        AsyncImage(
            model = url,
            contentDescription = "event item image",
            modifier = Modifier
                .size(86.dp)
                .background(Color.Gray),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = title, fontWeight = FontWeight.Bold, style = Typography.titleMedium)
            Text(
                text = previewText, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), maxLines = 2
            )
            Text(
                text = if (read) "Read" else "Unread",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}


@Preview
@Composable
fun EventItemPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        EventItem(
            title = "Title", url = "", previewText = "content", read = true
        ) {}

    }
}