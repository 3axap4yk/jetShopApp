package ru.godson.onlineshop.ui.theme.data

import ru.godson.onlineshop.R
import ru.godson.onlineshop.ui.theme.model.Product

class Datasource() {
    fun loadProducts(): MutableList<Product> {
        return mutableListOf<Product>(
            Product("Mango", "500", "120", "130", R.drawable.image1),
            Product("Apple", "1200", "65", "80", R.drawable.image2),
            Product("Lemon", "750", "52", "60", R.drawable.image3))
    }
}