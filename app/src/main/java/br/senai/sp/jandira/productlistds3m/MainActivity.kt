package br.senai.sp.jandira.productlistds3m

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.productlistds3m.components.CreateProductCard
import br.senai.sp.jandira.productlistds3m.dao.repository.ProductRepository
import br.senai.sp.jandira.productlistds3m.model.Product
import br.senai.sp.jandira.productlistds3m.ui.theme.ProductListDS3MTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListDS3MTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var productNameState by remember {
        mutableStateOf("")
    }

    var productPriceState by remember {
        mutableStateOf("")
    }

    var productDescriptionState by remember {
        mutableStateOf("")
    }

    var productsListState by remember {
        mutableStateOf(listOf<Product>())
    }

    val context = LocalContext.current

    val productRepository = ProductRepository(context)

    productsListState = productRepository.getProducts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lists with JetPack Compose",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Product's Name",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        OutlinedTextField(
            value = productNameState,
            onValueChange = {
                productNameState = it
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Product's Description",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        OutlinedTextField(
            value = productDescriptionState,
            onValueChange = {
                productDescriptionState = it
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Product's Price",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        OutlinedTextField(
            value = productPriceState,
            onValueChange = {
                productPriceState = it
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Button(
            onClick = {
                val p = Product(
                    productName = productNameState,
                    productPrice = productPriceState.toDouble(),
                    productDescription = productDescriptionState
                )
                val idNewProduct = productRepository.save(p)

                Toast.makeText(context, "$idNewProduct", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Save")
        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(productsListState) {
                CreateProductCard(product = it)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProductListDS3MTheme {
        Greeting("Android")
    }
}