package com.example.myfavoritecelebrities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnAddCeleb -> startActivity(Intent(this, CelebEntry::class.java))
            R.id.btnViewAllCelebs -> startActivity(Intent(this, ViewCelebrities::class.java))
            R.id.btnUpdateCeleb -> startActivity(Intent(this, ViewCelebrity::class.java))
            R.id.btnViewFaves -> startActivity(Intent(this, MyFavorites::class.java))
            R.id.ibnRemoveCeleb -> startActivity(Intent(this, RemoveCeleb::class.java))
            R.id.ibnMarkFavorite -> startActivity(Intent(this, MarkFavorite::class.java))
        }
    }


}
