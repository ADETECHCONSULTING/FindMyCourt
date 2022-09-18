package fr.traore.findmycourt.presentation

import com.google.android.gms.maps.model.LatLng
import fr.traore.findmycourt.domain.model.CourtSpot

sealed class MapEvent {
    object ToggleDarkMap: MapEvent()
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val spot: CourtSpot): MapEvent()

}
