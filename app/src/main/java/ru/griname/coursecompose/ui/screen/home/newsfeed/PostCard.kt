package ru.griname.coursecompose.ui.screen.home.newsfeed

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ru.griname.coursecompose.R
import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.StatisticsItem
import ru.griname.coursecompose.domain.StatisticsType

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewClickListener: (StatisticsItem) -> Unit,
    onShareClickListener: (StatisticsItem) -> Unit,
    onCommentClickListener: () -> Unit,
    onLikeClickListener: (StatisticsItem) -> Unit
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Header(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            PostContent(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(
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
private fun Header(feedPost: FeedPost) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = feedPost.communityName)
            Text(
                text = feedPost.publicationDate,
                color = MaterialTheme.colors.secondary
            )
        }

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null
        )
    }
}

@Composable
private fun PostContent(feedPost: FeedPost) {
    Column {
        Text(
            text = feedPost.contentText,
            fontSize = 14.sp,
            style = LocalTextStyle.current.merge(
                TextStyle(lineHeight = 1.5.em)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = feedPost.contentImageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun Statistics(
    statistics: List<StatisticsItem>,
    onViewClickListener: (StatisticsItem) -> Unit,
    onShareClickListener: (StatisticsItem) -> Unit,
    onCommentClickListener: () -> Unit,
    onLikeClickListener: (StatisticsItem) -> Unit
) {
    Row {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val viewsItem = statistics.getItemByType(StatisticsType.VIEW)
            IconWithText(
                viewsItem.count,
                R.drawable.ic_views_count
            ) { onViewClickListener(viewsItem) }
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharItem = statistics.getItemByType(StatisticsType.SHARE)
            IconWithText(
                sharItem.count,
                R.drawable.ic_share
            ) { onShareClickListener(sharItem) }
            val commentItem = statistics.getItemByType(StatisticsType.COMMENT)
            IconWithText(
                commentItem.count,
                R.drawable.ic_comment
            ) { onCommentClickListener() }
            val likeItem = statistics.getItemByType(StatisticsType.LIKE)
            IconWithText(
                likeItem.count,
                R.drawable.ic_like
            ) { onLikeClickListener(likeItem) }
        }
    }
}

private fun List<StatisticsItem>.getItemByType(type: StatisticsType): StatisticsItem {
    return this.find { it.type == type } ?: throw IllegalStateException("")
}

@Composable
private fun IconWithText(
    text: Int,
    iconResId: Int,
    clickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable { clickListener() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text.toString(),
            fontSize = 14.sp
        )
    }
}