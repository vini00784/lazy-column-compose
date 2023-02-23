package br.senai.sp.jandira.productlistds3m.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.productlistds3m.dao.product.ProductDao
import br.senai.sp.jandira.productlistds3m.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDb: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private lateinit var instance: AppDb

        fun getDataBase(context: Context): AppDb {
            // Check if the instance has already been created
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(context, AppDb::class.java, "db_app")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}