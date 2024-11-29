package com.msa.data.module

import com.msa.data.api.MusicApi
import com.msa.data.repository.MusicRepositoryImp
import com.msa.domain.repository.MusicRepository
import com.msa.domain.usecase.GetAllMusicsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class MusicModule {
    companion object {

        @Provides
        fun provideApi(): MusicApi {
            return MusicApi();
        }

        @Provides
        fun provideRespository(musiApi: MusicApi): MusicRepository {
            return MusicRepositoryImp(musiApi);
        }

        @Provides
        fun provideUsecase(repository: MusicRepository): GetAllMusicsUseCase {
            return GetAllMusicsUseCase(repository);
        }
    }
}