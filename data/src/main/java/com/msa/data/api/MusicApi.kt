package com.msa.data.api

import android.content.Context
import com.CodeBoy.MediaFacer.AudioGet
import com.CodeBoy.MediaFacer.MediaFacer
import com.CodeBoy.MediaFacer.mediaHolders.audioContent
import com.msa.domain.repository.MusicRepository
import javax.inject.Inject

class MusicApi {
    fun getAll(context: Context): List<audioContent> = MediaFacer
        .withAudioContex(context)
        .getAllAudioContent(AudioGet.externalContentUri);
}