package com.silbqt.vknewsclient.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silbqt.vknewsclient.domain.FeedPost
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainScreen() {
    Log.d("RECOMPOSITION", "MainScreen")

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }

    Scaffold (
        bottomBar = {
            NavigationBar {
                Log.d("RECOMPOSITION", "NavigationBar")

                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }
                val items = listOf(NavigationItem.Home, NavigationItem.Favorite, NavigationItem.Profile)
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.value == index,
                        onClick = { selectedItemPosition.value = index },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text( text = stringResource(id = item.titleResId) ) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        )
                    )
                }
            }
        }
    ) {
        Log.d("RECOMPOSITION", "Scaffold")
        Box(modifier = Modifier.padding(it)) {
            PostCard(
                modifier = Modifier
                    .padding(8.dp),
                feedPost = feedPost.value,
                onFooterItemClickListener = { newItem ->
                    val oldStatistics = feedPost.value.statistics
                    val newStatistics = oldStatistics.toMutableList().apply {
                        replaceAll { oldItem ->
                            if (oldItem.type == newItem.type) {
                                oldItem.copy(count = oldItem.count + 1)
                            } else {
                                oldItem
                            }
                        }
                    }
                    feedPost.value = feedPost.value.copy(statistics = newStatistics)
                }
            )
        }
    }
}