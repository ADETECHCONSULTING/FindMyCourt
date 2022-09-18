package fr.traore.findmycourt.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.traore.findmycourt.domain.model.CourtSpot
import fr.traore.findmycourt.domain.repository.CourtSpotRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val courtSpotRepository: CourtSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            courtSpotRepository.getCourtSpots().collectLatest { spots ->
                state = state.copy(
                    courtSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when(event) {
            is MapEvent.ToggleDarkMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isDarkMap) {
                            null
                        } else MapStyleOptions(MapStyle.json)

                    )
                )
            }

            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    courtSpotRepository.insertCourtSpot(
                        CourtSpot(
                            event.latLng.latitude,
                            event.latLng.longitude
                        )
                    )
                }
            }

            is MapEvent.OnInfoWindowLongClick -> {
                viewModelScope.launch {
                    courtSpotRepository.deleteCourtSpot(event.spot)
                }
            }
        }
    }

}