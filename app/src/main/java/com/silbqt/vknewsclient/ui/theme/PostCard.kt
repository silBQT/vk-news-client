package com.silbqt.vknewsclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.silbqt.vknewsclient.R
import com.silbqt.vknewsclient.domain.FeedPost
import com.silbqt.vknewsclient.domain.StatisticItem
import com.silbqt.vknewsclient.domain.StatisticType
import java.lang.IllegalStateException

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostHeader(feedPost = feedPost)
            Spacer(
                modifier = Modifier
                    .height(8.dp))
            PostContent(feedPost = feedPost)
            Spacer(
                modifier = Modifier
                    .height(8.dp))
            PostFooter(
                statistics = feedPost.statistics,
                onViewClickListener = onViewClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onLikeClickListener = onLikeClickListener
            )
        }

    }
}

@Composable
private fun PostHeader(
    feedPost: FeedPost
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        Image(
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Spacer(modifier = Modifier // Добавляет пространство между картинкой и текстом
            .width(8.dp))
        Column (
            modifier = Modifier
                .weight(1f)
        ){
            Text(
                text = feedPost.authorName,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = feedPost.publicationDate,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun PostContent(
    feedPost: FeedPost
) {
    Column {
        Text(text = feedPost.contentText)
        Spacer(modifier = Modifier
            .height(8.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = feedPost.contentImageResId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
private fun PostFooter(
    statistics: List<StatisticItem>,
    onViewClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .weight(1f)
        ){
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            Statistic(
                icon = R.drawable.ic_views_count,
                value = viewsItem.count.toString(),
                onItemClickListener = {
                    onViewClickListener(viewsItem)
                }
            )
        }
        Row (
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            Statistic(
                icon = R.drawable.ic_share,
                value = sharesItem.count.toString(),
                onItemClickListener = {
                    onShareClickListener(sharesItem)
                }
            )
            val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
            Statistic(
                icon = R.drawable.ic_comment,
                value = commentsItem.count.toString(),
                onItemClickListener = {
                    onCommentClickListener(commentsItem)
                }
            )
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            Statistic(
                icon = R.drawable.ic_like,
                value = likesItem.count.toString(),
                onItemClickListener = {
                    onLikeClickListener(likesItem)
                }
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("No item with type $type")
}

@Composable
private fun Statistic(
    icon: Int,
    value: String,
    onItemClickListener: () -> Unit
) {
    Row (
        modifier = Modifier.clickable { onItemClickListener() },
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier
            .width(5.dp))
        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}