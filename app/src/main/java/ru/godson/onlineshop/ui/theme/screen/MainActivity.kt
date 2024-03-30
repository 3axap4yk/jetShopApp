package ru.godson.onlineshop.ui.theme.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.godson.onlineshop.ui.theme.OnlineShopTheme
import ru.godson.onlineshop.ui.theme.data.Datasource
import androidx.compose.ui.platform.LocalContext
import ru.godson.onlineshop.ui.theme.components.ProductList
import ru.godson.onlineshop.ui.theme.components.SearchBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShopApp()
                }
            }
        }
    }
}

@Composable
fun ShopApp(){
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar()
    }

}

