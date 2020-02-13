package com.example.myfavoritecelebrities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_remove_celeb.*

class RemoveCeleb : AppCompatActivity() {

    val databaseHelper by lazy{CelebDatabaseHelper(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_celeb)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnUpdateCeleb -> {
                val celebId = etCelebID.text.toString()
                databaseHelper.removeCelebrityFromDatabase(celebId)
            }
        }
    }

}
