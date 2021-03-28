package com.chifamobile.medilista.medicament.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MedicamentDao {

    @Insert
    fun insert(medicament: Medicament)

    @Update
    fun update(medicament: Medicament)

    fun get(nEnregistreme: String) : Medicament?

    @Query("Select * FROM officine where N_ENREGISTREME like :content")
    fun search(content: String): LiveData<List<Medicament>>
}