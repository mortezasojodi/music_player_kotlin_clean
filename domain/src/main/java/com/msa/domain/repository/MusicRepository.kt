package com.msa.domain.repository

import android.content.Context
import com.CodeBoy.MediaFacer.mediaHolders.audioContent

interface MusicRepository {
    suspend fun getAll(context: Context): Result<List<audioContent>>
}