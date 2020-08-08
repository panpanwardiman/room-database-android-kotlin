package com.example.crudwithroomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.crudwithroomdatabase.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // annotation jika ada user yang sama maka ignore
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(User: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()
}