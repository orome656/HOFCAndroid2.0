package com.hofc.hofc

import android.arch.persistence.room.Room
import android.content.Context
import com.hofc.hofc.database.ActuDao
import com.hofc.hofc.database.HOFCDatabase
import com.hofc.hofc.repositories.ActuRepository
import com.hofc.hofc.services.IRestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import java.util.concurrent.*
import javax.inject.Singleton

/**
 * Created by maladota on 01/09/2017.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideActuRepository(actuDao: ActuDao, executor: Executor, restService: IRestService): ActuRepository {
        return ActuRepository(actuDao, restService, executor)
    }

    @Provides
    @Singleton
    fun provideHttpExecutor(): Executor {
        return ThreadPoolExecutor(1,5,30,TimeUnit.SECONDS, LinkedBlockingQueue<Runnable>())
    }

    @Provides
    @Singleton
    fun provideActuDao(database: HOFCDatabase): ActuDao {
        return database.actuDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): HOFCDatabase {
        return Room.databaseBuilder(context.applicationContext, HOFCDatabase::class.java, "hofc-database").build()
    }

    @Provides
    @Singleton
    fun provideRestService(): IRestService {
        return Retrofit.Builder().baseUrl("https://www.webhofc.fr/api/").build().create(IRestService::class.java)
    }
}