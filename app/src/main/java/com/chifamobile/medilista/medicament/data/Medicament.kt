package com.chifamobile.medilista.medicament.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "officine")
data class Medicament(

    @PrimaryKey @ColumnInfo(name = "N_ENREGISTREME")
    var nEnregistreme: String,
    @ColumnInfo(name = "NOM_COMMERCIAL")
    var nom_commercial: String,
    @ColumnInfo(name = "NOM_DCI")
    var nomDCI: String,
    @ColumnInfo(name = "DOSAGE")
    var dosage: String,
    @ColumnInfo(name = "UNITE")
    var unite: String,
    @ColumnInfo(name = "CONDITIONNEMENT")
    var conditionnement: String,
    @ColumnInfo(name = "TARIF_DE_REFERENCE")
    var tarifDeReference: Double,
    @ColumnInfo(name = "CODE_MEDIC")
    var codeMedic: String,
    @ColumnInfo(name = "OBSERVATION")
    var observation: String,
    @ColumnInfo(name = "CODE_DCI")
    var codeDCI: String
)