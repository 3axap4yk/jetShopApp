package ru.godson.onlineshop.ui.theme.components

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ru.godson.onlineshop.R
import ru.godson.onlineshop.ui.theme.data.Datasource
import ru.godson.onlineshop.ui.theme.model.Product
import ru.godson.onlineshop.ui.theme.model.StableWrapper


@Composable
fun SearchBar() {
    var searchResult by remember { mutableStateOf("") }
    var openDialog by remember { mutableStateOf(false) }
    var nameAdd by remember { mutableStateOf("") }
    var quantityAdd by remember { mutableStateOf("") }
    var caloriesAdd by remember { mutableStateOf("") }
    var priceAdd by remember { mutableStateOf("") }

    val context = LocalContext.current
    val contextStableWrapper = StableWrapper(context)
    //val toastProductText = Datasource().loadProducts().toString()


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {

        OutlinedTextField(
            value = searchResult,
            onValueChange = { searchResult = it },
            label = { Text("Search") },
            //placeholder = { Text("Click to search") },
            singleLine = true,
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { Toast.makeText(contextStableWrapper.value, "Search...", Toast.LENGTH_LONG).show() }
            ),
            modifier = Modifier.padding(5.dp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                if (searchResult != "") {
                    IconButton(
                        onClick = {
                            searchResult =
                                "" // Remove text from TextField when you press the 'X' icon
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(2.dp)
                                .size(25.dp)
                        )
                    }
                }
            })


        Image(
            painter = painterResource(id = R.drawable.add),
            contentDescription = "Add",
            modifier = Modifier
                .size(42.dp)
                .border(2.dp, color = Color.Gray, shape = CircleShape)
                .clickable { openDialog = true })

        if (openDialog){
            Dialog(
                onDismissRequest = { openDialog = false }) {
                Surface(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

                        Text(text = "Add product")

                        OutlinedTextField(
                            value = nameAdd,
                            onValueChange = {nameAdd = it},
                            placeholder = { Text("Name") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier.padding(5.dp))

                        OutlinedTextField(
                            value = quantityAdd,
                            onValueChange = {quantityAdd = it},
                            placeholder = { Text("Quantity") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.padding(5.dp))

                        OutlinedTextField(
                            value = caloriesAdd,
                            onValueChange = {caloriesAdd = it},
                            placeholder = { Text("Calories") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.padding(5.dp))

                        OutlinedTextField(
                            value = priceAdd,
                            onValueChange = {priceAdd = it},
                            placeholder = { Text("Price") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.padding(5.dp))

                        Button(onClick = {
                            openDialog = false
                            //Datasource().loadProducts().add(Product(nameAdd, quantityAdd.toInt(), caloriesAdd.toInt(), priceAdd.toInt(), R.drawable.image4))
                            Datasource().loadProducts().add(Product(nameAdd, quantityAdd, caloriesAdd, priceAdd, R.drawable.image4))
                            val toastText = Datasource().loadProducts().last().toString()
                            Toast.makeText(contextStableWrapper.value, toastText/*"Saving..."*/, Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }

    ProductList(
        productList = Datasource().loadProducts(),
        searchResult
    )

//    return searchResult
}