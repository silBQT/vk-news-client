package com.silbqt.vknewsclient.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silbqt.vknewsclient.MainViewModel
import com.silbqt.vknewsclient.domain.FeedPost

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Log.d("RECOMPOSITION", "MainScreen")

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
        val feedPost = viewModel.feedPost.observeAsState(FeedPost())

        Box(modifier = Modifier.padding(it)) {
            PostCard(
                modifier = Modifier
                    .padding(8.dp),
                feedPost = feedPost.value,
                onViewClickListener = { // можно использовать метод reference, т.е. onViewClickListener = viewModel::updateCount
                    viewModel.updateCount(it)
                },
                onShareClickListener = {
                    viewModel.updateCount(it)
                },
                onCommentClickListener = {
                    viewModel.updateCount(it)
                },
                onLikeClickListener = {
                    viewModel.updateCount(it)
                }
            )
        }
    }
}