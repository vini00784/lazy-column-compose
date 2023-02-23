package br.senai.sp.jandira.productlistds3m.dao.repository

import br.senai.sp.jandira.productlistds3m.model.Product

class ProductRepository {
    companion object {
        fun getProducts(): List<Product> {
            return listOf(
                Product(id = 1, productName = "Mouse Bluetooth", productDescription = "Mouse bacana bem da hora", productPrice =  29.99),
                Product(id =2, productName = "Caneca do coringão", productDescription = "Caneca", productPrice = 19.10),
                Product()
            )
        }
    }
}