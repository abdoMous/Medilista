package com.chifamobile.medilista

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.chifamobile.medilista.medicament.data.Medicament
import com.chifamobile.medilista.medicament.data.MedicamentDao
import com.chifamobile.medilista.medicament.data.MedicamentDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.notification.RunListener
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MedicamentDatabaseTest {
    private lateinit var medicamentDao: MedicamentDao
    private lateinit var db: MedicamentDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
//        val context = ApplicationProvider.getApplicationContext<Context>()

        //Using an in-memory database because the information stored here disappears when
        // the process is killed
        db = Room.inMemoryDatabaseBuilder(context, MedicamentDatabase::class.java)
                // Allowing main thread queries, just for testing
            .allowMainThreadQueries()
            .build()

        medicamentDao = db.medicamentDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetMedicament() {
        val medicament = Medicament(
            nEnregistreme = "00010",
            nom_commercial = "ZYRTEC",
            nomDCI = "CETIRIZINE",
            dosage = "10",
            unite = "MG",
            conditionnement = "B/10",
            tarifDeReference = 60.0,
            codeMedic = "04601A00397",
            observation = "En cas de prescription de ce medicament antérieure à la date du 13.03.2010, il y'a lieu d'appliquer le tarif de référence suivant: 75.00DA.",
            codeDCI = "01A003"
        )
        medicamentDao.insert(medicament)
        val medicamentFromDatabase = medicamentDao.get(medicament.nEnregistreme)
        assert(medicament == medicamentFromDatabase)
    }
}