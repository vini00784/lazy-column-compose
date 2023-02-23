package br.senai.sp.jandira.productlistds3m.model

data class Product(
    var id: Long = 0,
    var productName: String = "",
    var productDescription: String = "",
    var productPrice: Double = 0.0
)