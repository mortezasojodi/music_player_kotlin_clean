package com.msa.data.repository

import android.content.Context
import com.CodeBoy.MediaFacer.mediaHolders.audioContent
import com.msa.data.api.MusicApi
import com.msa.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImp @Inject constructor(val api: MusicApi) : MusicRepository {

    override suspend fun getAll(context: Context): Result<List<audioContent>> {
        return try {
            Result.success(api.getAll(context))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}