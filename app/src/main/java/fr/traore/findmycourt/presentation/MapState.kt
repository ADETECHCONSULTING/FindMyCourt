package fr.traore.findmycourt.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import fr.traore.findmycourt.domain.model.CourtSpot

data class MapState(
    val properties: MapProperties = MapProperties(),
    val courtSpots: List<CourtSpot> = emptyList(),
    val isDarkMap: Boolean = false
)