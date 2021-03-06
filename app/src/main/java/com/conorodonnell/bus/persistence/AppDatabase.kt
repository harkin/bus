package com.conorodonnell.bus.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Stop::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stops(): StopDao
}
