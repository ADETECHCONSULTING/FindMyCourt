package fr.traore.findmycourt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CourtSpotEntity::class],
    version = 1
)
abstract class CourtSpotDatabase: RoomDatabase() {

    abstract val courtSpotDao: CourtSpotDao



}