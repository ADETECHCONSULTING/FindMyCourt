package fr.traore.findmycourt.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CourtSpotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourtSpot(spot: CourtSpotEntity)

    @Delete
    suspend fun deleteCourtSpot(spot: CourtSpotEntity)

    @Query("SELECT * FROM courtspotentity")
    fun getCourtSpots(): Flow<List<CourtSpotEntity>>
}
