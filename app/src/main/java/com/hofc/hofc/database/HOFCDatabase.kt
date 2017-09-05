package com.hofc.hofc.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.hofc.hofc.database.converters.DateConverter
import com.hofc.hofc.models.Actu

/**
 * Created by maladota on 01/09/2017.
 */
@Database(entities = arrayOf(Actu::class), version = 1)
@TypeConverters(DateConverter::class)
abstract class HOFCDatabase: RoomDatabase() {
    companion object {
        private val DATABASE_NAME = "HOFC"
        // For Singleton instantiation
        private val LOCK = Any()
        private var sInstance: HOFCDatabase? = null
        @Synchronized
        fun getInstance(context: Context): HOFCDatabase {
            if (sInstance == null) {
                synchronized(LOCK) {
                    if (sInstance == null) {
                        sInstance = Room.databaseBuilder(context.getApplicationContext(),
                                HOFCDatabase::class.java!!, DATABASE_NAME).build()
                    }
                }
            }
            return sInstance!!
        }
    }
    abstract fun actuDao(): ActuDao
}