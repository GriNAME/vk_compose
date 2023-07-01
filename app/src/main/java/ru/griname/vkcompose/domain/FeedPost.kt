package ru.griname.vkcompose.domain

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import ru.griname.vkcompose.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "Post Name",
    val publicationDate: String = "14:30",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = LoremIpsum(15).values.first(),
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticsItem> = listOf(
        StatisticsItem(StatisticsType.VIEW, 946),
        StatisticsItem(StatisticsType.SHARE, 5),
        StatisticsItem(StatisticsType.COMMENT, 9),
        StatisticsItem(StatisticsType.LIKE, 27),
    )
)
