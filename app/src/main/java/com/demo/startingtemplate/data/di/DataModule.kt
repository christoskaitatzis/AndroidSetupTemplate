package com.demo.startingtemplate.data.di

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.demo.startingtemplate.data.MyModelRepository
import com.demo.startingtemplate.data.DefaultMyModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsMyModelRepository(
        myModelRepository: DefaultMyModelRepository
    ): MyModelRepository
}

class FakeMyModelRepository @Inject constructor() : MyModelRepository {
    override val myModels: Flow<List<String>> = flowOf(fakeMyModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeMyModels = listOf("One", "Two", "Three")
