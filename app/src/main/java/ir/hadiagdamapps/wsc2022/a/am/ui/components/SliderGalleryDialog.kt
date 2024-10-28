package ir.hadiagdamapps.wsc2022.a.am.ui.components

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage

@Composable
fun SliderGalleryDialog(
    onDismiss: () -> Unit,
    pictures: List<String>,
    startIndex: Int
) {
    Dialog(onDismissRequest = onDismiss) {


        val state = rememberLazyListState(initialFirstVisibleItemIndex = startIndex)
        val snap = rememberSnapFlingBehavior(state)


        LazyRow(
            state = state,
            flingBehavior = snap,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items(pictures) { picture ->
                AsyncImage(
                    model = picture, contentDescription = "thumbnail",
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                )
            }

        }

    }
}