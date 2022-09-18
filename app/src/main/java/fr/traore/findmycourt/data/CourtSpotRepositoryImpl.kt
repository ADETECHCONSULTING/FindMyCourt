package fr.traore.findmycourt.data

import fr.traore.findmycourt.domain.model.CourtSpot
import fr.traore.findmycourt.domain.repository.CourtSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CourtSpotRepositoryImpl(
    private val courtSpotDao: CourtSpotDao
): CourtSpotRepository {
    override suspend fun insertCourtSpot(spot: CourtSpot) {
        courtSpotDao.insertCourtSpot(spot.toCourtSpotEntity())
    }

    override suspend fun deleteCourtSpot(spot: CourtSpot) {
        courtSpotDao.deleteCourtSpot(spot.toCourtSpotEntity())
    }

    override fun getCourtSpots(): Flow<List<CourtSpot>> {
        return courtSpotDao.getCourtSpots().map { spots ->
            spots.map { it.toCourtSpot() }
        }
    }
}