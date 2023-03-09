package com.example.koinexample.data.repo

import com.example.koinexample.data.models.Content
import com.example.koinexample.data.models.Media
import com.example.koinexample.data.network.ApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MediaRepositoryImpl(
    private val apiInterface: ApiInterface
) : MediaRepository {
    private var media: Media? = null


    override fun getMedias(): Flow<Media> = flow {
        media = apiInterface.getMedias()
        emit(media!!)
    }

    override fun removeItem(position: Int): Flow<Media> = flow {
        val tmp: MutableList<Content> = media?.content as MutableList<Content>
        tmp.removeAt(position)
        media?.content = tmp
        emit(media!!)
    }

    override fun undoDeleteItem(content: Content, position: Int): Flow<Media> = flow {
        val tmp: MutableList<Content> = media?.content as MutableList<Content>
        tmp.add(position, content)
        media?.content = tmp
        emit(media!!)
    }
}