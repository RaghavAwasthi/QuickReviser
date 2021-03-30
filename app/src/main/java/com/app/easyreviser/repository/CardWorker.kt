package com.app.easyreviser.repository

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.app.easyreviser.repository.db.AppDatabase

class CardWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        AppRepository.getInstance(applicationContext).clearALL()
        AppDatabase.getInstance(applicationContext).cardDao().getAll().forEach {

            AppRepository.getInstance(applicationContext).addDayCards(it)
        }

        return Result.success()
    }
}