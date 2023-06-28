package ru.griname.coursecompose.domain

import ru.griname.coursecompose.R

data class CommentPost(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment text lite a fish",
    val publicationDate: String = "14:35"
)
