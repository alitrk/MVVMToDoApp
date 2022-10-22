package com.example.mvvmtodoapp.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmtodoapp.data.datasource.NotlarDataSource
import com.example.mvvmtodoapp.data.repo.NotlarRepository
import com.example.mvvmtodoapp.room.NotlarDao
import com.example.mvvmtodoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotlarRepository(nds: NotlarDataSource) : NotlarRepository {
        return NotlarRepository(nds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(ndao: NotlarDao) : NotlarDataSource {
        return NotlarDataSource(ndao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : NotlarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"notlar.sqlite")
            .createFromAsset("notlar.sqlite").build()
        return  vt.getNotlarDao()
    }
}