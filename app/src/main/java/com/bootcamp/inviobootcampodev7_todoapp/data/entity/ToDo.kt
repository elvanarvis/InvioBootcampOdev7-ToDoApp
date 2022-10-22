package com.bootcamp.inviobootcampodev7_todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todo")
data class ToDo(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "do_id") @NotNull var do_id: Int,
                @ColumnInfo(name = "do_txt") @NotNull var do_txt: String,
                @ColumnInfo(name = "done") @NotNull var done : Int): Serializable {
}