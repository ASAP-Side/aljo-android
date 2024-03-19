package team.asap.aljo.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import team.asap.aljo.local.database.dao.DummyDAO
import team.asap.aljo.local.database.entity.DummyData

@Database(
    entities = [DummyData::class],
    version = 1,
    exportSchema = true,
)
abstract class DummyDatabase : RoomDatabase() {

    abstract fun dummyDAO(): DummyDAO

    companion object {
        const val DATA_BASE_NAME = "dummy-database"
    }

}
