package br.senai.sp.jandira.productlistds3m.dao.product

import androidx.room.*
import br.senai.sp.jandira.productlistds3m.model.Product

@Dao
interface ProductDao {
    @Insert
    fun saveProduct(product: Product): Long

    @Delete
    fun deleteProduct(product: Product): Int

    @Query("SELECT * FROM tbl_product ORDER BY product_name ASC")
    fun getAllProducts(): List<Product>
}