package ru.griname.coursecompose.domain

data class FeedPost(
    val id: Int = 0,
    val communityName: String,
    val publicationDate: String,
    val avatarResId: Int,
    val contentText: String,
    val contentImageResId: Int,
    val statistics: List<StatisticsItem>
)
