package team.asap.aljo.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dummy")
data class DummyData(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String,
)