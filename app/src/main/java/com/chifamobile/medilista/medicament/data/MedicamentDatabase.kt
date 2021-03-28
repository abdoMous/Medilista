package com.chifamobile.medilista.medicament.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Medicament::class], version = 1, exportSchema = false)
abstract class MedicamentDatabase : RoomDatabase(){

    abstract val medicamentDao : MedicamentDao

    companion object {
        @Volatile
        private var INSTANCE : MedicamentDatabase? = null

        fun getInstance(context: Context) : MedicamentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MedicamentDatabase::class.java,
                        "officine"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }

        }
    }
}