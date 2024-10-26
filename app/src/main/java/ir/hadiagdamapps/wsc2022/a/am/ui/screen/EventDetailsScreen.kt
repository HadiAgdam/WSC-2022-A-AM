package ir.hadiagdamapps.wsc2022.a.am.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.wsc2022.a.am.ui.theme.Typography

@Composable
fun EventDetailsScreen(
    title: String,
    viewCount: Int,
    pictures: List<String>,
    text: String
) {


    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(top = 48.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Event Details", style = Typography.titleLarge, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(36.dp))

        Text(text = title, style = Typography.titleMedium)
        Text(text = viewCount.toString())


        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {


//            AsyncImage(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(12.dp)
//                    .fillMaxHeight(), model = pictures[0],
//                contentDescription = "image 1"
//            )
//
//            AsyncImage(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(12.dp)
//                    .fillMaxHeight(), model = pictures[1],
//                contentDescription = "image 2"
//            )
//
//            AsyncImage(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(12.dp)
//                    .fillMaxHeight(), model = pictures[2],
//                contentDescription = "image 3"
//            )
        }



        Text(text = text, modifier = Modifier.fillMaxSize().padding(12.dp))

    }

}


@Preview
@Composable
fun EventDetailsScreenPreView() {
    EventDetailsScreen(title = "Title", viewCount = 91, pictures = listOf(), text = "content")
}