package com.example.koinexample.data.repo

import com.example.koinexample.data.models.Content
import com.example.koinexample.data.models.Media
import kotlinx.coroutines.flow.Flow

interface MediaRepository {

    fun getMedias(): Flow<Media>

    fun removeItem(position: Int): Flow<Media>

    fun undoDeleteItem(content: Content, position: Int): Flow<Media>
}