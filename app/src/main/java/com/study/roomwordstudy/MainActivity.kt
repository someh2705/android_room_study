package com.study.roomwordstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

@Entity(tableName = "word_table")
data class Word(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "word") val word: String)