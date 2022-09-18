package fr.traore.findmycourt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourtSpotEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey val id: Int? = null
)