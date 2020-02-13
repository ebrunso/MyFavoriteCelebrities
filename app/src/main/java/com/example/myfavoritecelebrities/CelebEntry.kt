package com.example.myfavoritecelebrities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_celeb_entry.*

class CelebEntry : AppCompatActivity() {

    val databaseHelper by lazy{CelebDatabaseHelper(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celeb_entry)

    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnAddCeleb -> {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val celebId = etCelebID.text.toString()
                val isFavorite = "false"
                databaseHelper.insertCelebIntoDatabase(Celebrity(firstName, lastName, celebId, isFavorite))
            }
        }
    }

}
