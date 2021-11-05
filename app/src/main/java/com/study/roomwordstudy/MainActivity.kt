package com.study.roomwordstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

@Entity(tableName = "word_table")
data class Word(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "word") val word: String)

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}