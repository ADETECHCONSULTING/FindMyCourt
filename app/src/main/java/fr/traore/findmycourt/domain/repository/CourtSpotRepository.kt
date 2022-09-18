package fr.traore.findmycourt.domain.repository

import fr.traore.findmycourt.domain.model.CourtSpot
import kotlinx.coroutines.flow.Flow

interface CourtSpotRepository {
    suspend fun insertCourtSpot(spot: CourtSpot)
    suspend fun deleteCourtSpot(spot: CourtSpot)
    fun getCourtSpots(): Flow<List<CourtSpot>>
}