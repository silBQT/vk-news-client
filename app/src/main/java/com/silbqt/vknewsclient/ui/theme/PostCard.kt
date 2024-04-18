package com.silbqt.vknewsclient.ui.theme

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silbqt.vknewsclient.R

@Composable
fun PostCard() {
    Card (
        shape = RoundedCornerShape(5.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostHeader()
            Spacer(
                modifier = Modifier
                    .height(8.dp))
            PostContent()
            Spacer(
                modifier = Modifier
                    .height(8.dp))
            PostFooter()
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PostHeader() {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        Image(
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
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
                text = "/dev/null",
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "14:00",
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

@Preview(showBackground = true)
@Composable
private fun PostContent() {
    Column {
        Text(text = "кабаныч, когда узнал, что если сотрудникам " +
                "не лпатить они начинают умирать от голода")
        Spacer(modifier = Modifier
            .height(8.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.post_content_image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PostFooter() {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .weight(1f)
        ){
            Statistic(
                icon = R.drawable.ic_views_count, value = "916"
            )
        }
        Row (
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Statistic(
                icon = R.drawable.ic_share,
                value = "7"
            )
            Statistic(
                icon = R.drawable.ic_comment,
                value = "8"
            )
            Statistic(
                icon = R.drawable.ic_like,
                value = "23")
        }
    }
}

@Composable
private fun Statistic(icon: Int, value: String) {
    Row (
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

@Preview
@Composable
private fun PreviewCardLight() {
    VkNewsClientTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview
@Composable
private fun PreviewCardDark() {
    VkNewsClientTheme(darkTheme = true) {
        PostCard()
    }
}