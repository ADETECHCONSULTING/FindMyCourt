package fr.traore.findmycourt.data

import fr.traore.findmycourt.domain.model.CourtSpot

fun CourtSpotEntity.toCourtSpot(): CourtSpot {
    return CourtSpot(
        lat, lng, id
    )
}

fun CourtSpot.toCourtSpotEntity(): CourtSpotEntity {
    return CourtSpotEntity(
        lat, lng, id
    )
}