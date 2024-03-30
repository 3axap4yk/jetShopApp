package ru.godson.onlineshop.ui.theme.model

import androidx.annotation.DrawableRes

data class Product(var name: String,
                   var quantity: String, //Int
                   var calories: String, //Int
                   var price: String, //Int
                   @DrawableRes val imageResourceId: Int)