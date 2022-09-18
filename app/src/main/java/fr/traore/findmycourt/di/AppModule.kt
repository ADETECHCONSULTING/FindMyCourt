package fr.traore.findmycourt.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.traore.findmycourt.CourtSpotApplication
import fr.traore.findmycourt.data.CourtSpotDatabase
import fr.traore.findmycourt.data.CourtSpotRepositoryImpl
import fr.traore.findmycourt.domain.repository.CourtSpotRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesCourtSpotDatabase(app: Application): CourtSpotDatabase {
        return Room.databaseBuilder(
            app,
            CourtSpotDatabase::class.java,
            "court_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCourtSpotRepository(db: CourtSpotDatabase): CourtSpotRepository {
        return CourtSpotRepositoryImpl(db.courtSpotDao)
    }

}