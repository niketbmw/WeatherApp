package com.bti.weatherapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.bti.weatherapp.data.sources.local.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    private const val COUNTER_PREFERENCE = "counter_preference"

    @Singleton
    @Provides
    fun providePostDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PostDatabase::class.java,
        "posts_database.db"
    ).build()

    @Singleton
    @Provides
    fun postDatabaseDao(database: PostDatabase) = database.getPostDatabaseDao()

    @Singleton
    @Provides
    fun provideCounterPreferenceDataStore(
        @ApplicationContext appContext: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile(COUNTER_PREFERENCE) }
        )
    }
}