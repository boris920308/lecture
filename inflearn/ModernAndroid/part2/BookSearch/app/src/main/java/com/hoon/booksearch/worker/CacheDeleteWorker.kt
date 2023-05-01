package com.hoon.booksearch.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class CacheDeleteWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val cacheDeleteResult: String
) : Worker(context, workerParams) {

    // worker는 singleton component안에 설치된 의존성만 주입 받을 수 있다
    override fun doWork(): Result {
        return try {
//            Log.d("WorkManager", "Cache has successfully deleted")
            Log.d("WorkManager", cacheDeleteResult)
            Result.success()
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
    }

}