package ru.griname.vkcompose.domain

import ru.griname.vkcompose.R

data class CommentPost(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment text lite a fish",
    val publicationDate: String = "14:35"
)
