package br.senai.sp.jandira.productlistds3m.dao.repository

import br.senai.sp.jandira.productlistds3m.model.Product

class ProductRepository {
    companion object {
        fun getProducts(): List<Product> {
            val products = listOf(
                Product(),
                Product(),
                Product()
            )
            return products
        }
    }
}