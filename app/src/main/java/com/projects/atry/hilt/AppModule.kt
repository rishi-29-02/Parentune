package com.projects.atry.hilt

import android.content.Context
import com.projects.atry.api.ApiInterface
import com.projects.atry.repository.ParentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideParentRepository(apiInterface: ApiInterface, @ApplicationContext context: Context) : ParentRepository {
        return ParentRepository(apiInterface, context)
    }
}