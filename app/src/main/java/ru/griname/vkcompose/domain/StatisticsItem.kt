package ru.griname.vkcompose.domain

data class StatisticsItem(
    val type: StatisticsType,
    val count: Int = 0
)

enum class StatisticsType {
    VIEW, COMMENT, SHARE, LIKE
}
