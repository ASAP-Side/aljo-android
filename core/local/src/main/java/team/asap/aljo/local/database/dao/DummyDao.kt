package team.asap.aljo.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import team.asap.aljo.local.database.entity.DummyData

@Dao
interface DummyDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: DummyData)

}