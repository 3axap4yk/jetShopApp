package ru.godson.onlineshop.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.godson.onlineshop.ui.theme.data.Datasource
import ru.godson.onlineshop.ui.theme.model.Product
import java.util.ArrayList
import java.util.Locale

@Composable
fun ProductList(productList: List<Product>, search: String) {

    var filteredProducts = if (search == ""){
        productList
    } else {
        val filter = Datasource().loadProducts().filter { p -> p.toString().contains(search, ignoreCase = true) }
        filter
    }
    LazyColumn(modifier = Modifier) {
        items(filteredProducts) { product ->
            ProductCard(
                product = product,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    repeat(3) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height((100.dp))
        ) {
            Row {
                Image(
                    painter = painterResource(product.imageResourceId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(modifier = Modifier) {
                        Text(
                            text = product.name,
                            fontSize = 21.sp,
                            modifier = Modifier.padding(13.dp)
                        )
                        Row(modifier = Modifier) {
                            Text(
                                text = product.quantity.toString(),
                                fontSize = 17.sp,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .border(2.dp, color = Color.Gray)
                                    .padding(2.dp)
                            )
                            Text(
                                text = "${product.calories.toString()} Kcal",
                                fontSize = 17.sp,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .border(2.dp, color = Color.Gray)
                                    .padding(2.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.End
                    ) {
                        val removeText = Text(
                            text = "X",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(end = 10.dp, top = 2.dp)
                                .clickable { })
                        Text(
                            text = "${product.price.toString()} Rub",
                            fontSize = 19.sp,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                }

            }
        }
    }
}