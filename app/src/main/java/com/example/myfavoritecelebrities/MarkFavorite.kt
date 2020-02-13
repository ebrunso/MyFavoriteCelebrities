package com.example.myfavoritecelebrities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_mark_favorite.*

class MarkFavorite : AppCompatActivity() {

    val databaseHelper by lazy{CelebDatabaseHelper(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_favorite)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnGetCelebInfo -> {
                val celebID = etCelebID.text.toString()
                databaseHelper.getOneCelebFromDatabase(celebID)
            }

            R.id.btnMakeFaveCeleb -> {
                val firstName = tvFirstName.text.toString()
                val lastName = tvLastName.text.toString()
                val celebId = etCelebID.text.toString()
                val isFavorite = etIsFavorite.text.toString()
                databaseHelper.updateFavoriteCelebrityInDatabase(Celebrity(firstName, lastName, celebId, isFavorite))
            }
        }
    }

}
