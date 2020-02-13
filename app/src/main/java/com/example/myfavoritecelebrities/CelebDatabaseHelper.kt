package com.example.myfavoritecelebrities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class CelebDatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,
    null, DATABASE_VERSION){
    override fun onCreate(sqLiteDatabase : SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_CELEB_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)
    }

    fun insertCelebIntoDatabase(celebrity: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }

    fun getOneCelebFromDatabase(celebId: String) : Celebrity? {
        val database = readableDatabase
        var celebrity : Celebrity? = null
        val cursor = database.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_CELEB_ID " +
                "= '$celebId'", null)

        if(cursor.moveToFirst()){
            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val celebId = cursor.getString(cursor.getColumnIndex(COL_CELEB_ID))
            val isFavorite = cursor.getString(cursor.getColumnIndex(COL_IS_FAVORITE))
            celebrity = Celebrity(firstName, lastName, celebId, isFavorite)
        }
        cursor.close()
        database.close()
        return celebrity
    }

    fun getAllCelebritiesFromDatabase() : ArrayList<Celebrity> {
        val database = readableDatabase
        var celebList : ArrayList<Celebrity> = ArrayList<Celebrity>()
        val cursor = database.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if(cursor.moveToFirst()) {
            do{
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val celebId = cursor.getString(cursor.getColumnIndex(COL_CELEB_ID))
                val isFavorite = cursor.getString(cursor.getColumnIndex(COL_IS_FAVORITE))
                val celebrity = Celebrity(firstName, lastName, celebId, isFavorite)
                celebList.add(celebrity)
            } while(cursor.moveToNext())
        }
        cursor.close()
        database.close()
        return celebList
    }

    fun updateCelebrityInDatabase(celebrity: Celebrity){
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.update(TABLE_NAME, contentValues, "$COL_CELEB_ID = ?", arrayOf(celebrity.celebId))
        database.close()
    }

    fun removeCelebrityFromDatabase(celebId: String){
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_CELEB_ID = ?", arrayOf(celebId))
        database.close()
    }

    fun updateFavoriteCelebrityInDatabase(celebrity: Celebrity){
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.update(TABLE_NAME, contentValues, "$COL_CELEB_ID = ?", arrayOf(celebrity.celebId))
        database.close()


    }
}