package ir.hadiagdamapps.wsc2022.a.am

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.hadiagdamapps.wsc2022.a.am.ui.screen.EventsScreen
import ir.hadiagdamapps.wsc2022.a.am.ui.theme.WSC2022AAMTheme
import ir.hadiagdamapps.wsc2022.a.am.ui.viewmodel.EventScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WSC2022AAMTheme {

                var selectedIndex by remember {
                    mutableIntStateOf(0)
                }

                val eventScreenViewModel by remember {
                    mutableStateOf(EventScreenViewModel({

                    }, this))
                }

                Scaffold(bottomBar = {
                    NavigationBar {
                        NavigationBarItem(selected = selectedIndex == 0,
                            onClick = {
                                selectedIndex = 0
                            },
                            icon = {
                                Text(
                                    text = "Events"
                                )
                            })

                        NavigationBarItem(
                            selected = selectedIndex == 1,
                            onClick = {
                                selectedIndex = 1
                            },
                            icon = {
                                Text(
                                    text = "Tickets"
                                )
                            })

                        NavigationBarItem(
                            selected = selectedIndex == 2,
                            onClick = {
                                selectedIndex = 2

                            },
                            icon = { Text(text = "Records") })
                    }
                }) {
                    Box(modifier = Modifier.padding(it)) {

                        when (selectedIndex) {
                            0 ->
                                EventsScreen(viewModel = eventScreenViewModel)

                            1 -> {}

                            2 -> {}
                        }

                    }
                }
            }
        }
    }
}
