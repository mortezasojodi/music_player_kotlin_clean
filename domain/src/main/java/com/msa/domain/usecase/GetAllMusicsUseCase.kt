package com.msa.domain.usecase

import android.content.Context
import com.CodeBoy.MediaFacer.mediaHolders.audioContent
import com.msa.domain.repository.MusicRepository
import javax.inject.Inject

class GetAllMusicsUseCase @Inject constructor(val repository: MusicRepository) {
    suspend fun invoke(context: Context): Result<List<audioContent>> = repository.getAll(context)
}