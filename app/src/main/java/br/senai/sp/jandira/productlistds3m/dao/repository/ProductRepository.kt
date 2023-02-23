package br.senai.sp.jandira.productlistds3m.dao.repository

import android.content.Context
import br.senai.sp.jandira.productlistds3m.dao.AppDb
import br.senai.sp.jandira.productlistds3m.model.Product

class ProductRepository(context: Context) {

    private val db = AppDb.getDataBase(context)

    fun getProducts(): List<Product> {
        return db.productDao().getAllProducts()
    }

    fun save(product: Product): Long {
        return db.productDao().saveProduct(product)
    }

}