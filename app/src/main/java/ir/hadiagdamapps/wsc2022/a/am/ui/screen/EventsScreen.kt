package ir.hadiagdamapps.wsc2022.a.am.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.wsc2022.a.am.ui.components.EventItem
import ir.hadiagdamapps.wsc2022.a.am.ui.theme.Typography
import ir.hadiagdamapps.wsc2022.a.am.ui.viewmodel.EventScreenViewModel

@Composable
fun EventsScreen(viewModel: EventScreenViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 48.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Events List", style = Typography.titleLarge, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(36.dp))

        TabRow(selectedTabIndex = viewModel.selectedTab) {

            Tab(selected = viewModel.selectedTab == 0, onClick = { viewModel.tabChanged(0) }, modifier = Modifier.height(36.dp)) {
                Text(text = "All")
            }

            Tab(selected = viewModel.selectedTab == 1, onClick = { viewModel.tabChanged(1) }, modifier = Modifier.height(36.dp)) {
                Text(text = "Unread")
            }

            Tab(selected = viewModel.selectedTab == 2, onClick = { viewModel.tabChanged(2) }, modifier = Modifier.height(36.dp)) {
                Text(text = "Read")
            }

        }
        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {
            items(viewModel.events) {
                EventItem(
                    url = it.pictures[0],
                    title = it.title,
                    previewText = it.text,
                    read = it.read) {
                    viewModel.eventClick(it)
                }
            }
        }


    }



}