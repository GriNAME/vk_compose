package ru.griname.coursecompose

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.StatisticsItem
import ru.griname.coursecompose.domain.StatisticsType

class MainViewModel : ViewModel() {

    private val list = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it,
                    communityName = "$it Post Name",
                    publicationDate = "14:${it}0",
                    avatarResId = R.drawable.post_comunity_thumbnail,
                    contentText = LoremIpsum(it).values.first(),
                    contentImageResId = R.drawable.post_content_image,
                    statistics = listOf(
                        StatisticsItem(StatisticsType.VIEW, 946),
                        StatisticsItem(StatisticsType.SHARE, 5),
                        StatisticsItem(StatisticsType.COMMENT, 9),
                        StatisticsItem(StatisticsType.LIKE, 27),
                    )
                )
            )
        }
    }

    private val _feedPosts = MutableLiveData<List<FeedPost>>(list)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    fun updateCount(item: StatisticsItem, feedPost: FeedPost) {
        item
        feedPost
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
    }

    fun remove(feedPost: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        oldPosts.remove(feedPost)
        _feedPosts.value = oldPosts
    }
}