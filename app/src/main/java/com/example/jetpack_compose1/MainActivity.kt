package com.example.jetpack_compose1

import android.os.Bundle
import android.text.Selection
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.jetpack_compose1.ui.theme.MyFontFamily
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            disp()
//            disp2(name = "Ankit")
//            disp3()
//            disp4()
//            SimpleText()
//            LongText()
//            SelectableText()
//            PartiallySelectedText()
//            RowExample()
//            ColumnExample()
//            LazyRowExample()
//            LazyRowColumn()
//            boxExample()
//            MaterialUiApp()
//            ImageAssetExample()
//            ImageInternetExample()
//            IconExample()
//            CardExample()
//            StatefulExample()
//            HelloScreen()
//            ButtonsExample()
            TextFieldExample()
        }
    }
}

@Composable
fun disp() {
    Text(text = "Hello Kotlin Jetpack", fontSize = 30.sp)
}

@Composable
fun disp2(name: String) {
    Text(text = "Hey $name whatsapp!", fontSize = 30.sp)
}

@Composable
fun disp3() {
    Column() {
        Text(text = "Ankit", fontSize = 20.sp)
        Text(text = "Ankit kumar", fontSize = 20.sp)
        Text(text = "Mathura", fontSize = 20.sp)
        Text(text = "tiger", fontSize = 20.sp)
    }
}

@Composable
fun disp4() {
    val names = listOf<String>("Ankit", "Ak", "bingo", "Hey")
    Column() {
        for (names in names) {
            Text(text = "Hello $names", fontSize = 30.sp)
        }
    }
}

@Composable
fun SimpleText() {
    Text(
        text = "Hey Kotlin",
        fontSize = 30.sp,
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = MyFontFamily,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .width(410.dp)
    )
}

@Composable
fun LongText() {
    Text(text = "Jetpack Compose".repeat(10), fontSize = 30.sp, maxLines = 2)
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text(text = "Jetpack kotlin ", fontSize = 30.sp)
    }
}

@Composable
fun PartiallySelectedText() {
    Column {

        SelectionContainer {
            Column {
                Text(text = "Jetpack kotlin ", fontSize = 30.sp)
                DisableSelection {
                    Text(text = "This is not a Selected Text", fontSize = 30.sp)
                }
            }
        }
        Text(text = "This is Not Selected Text", fontSize = 30.sp)
    }
}

@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Gray)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "first", fontSize = 30.sp)
        Text(text = "JetPack", fontSize = 30.sp)
        Text(text = "Compose", fontSize = 30.sp)
        Text(text = "Hello", fontSize = 30.sp)
        Text(text = "JetPack", fontSize = 30.sp)
        Text(text = "Compose", fontSize = 30.sp)
        Text(text = "JetPack", fontSize = 30.sp)
        Text(text = "Compose", fontSize = 30.sp)
        Text(text = "Hello", fontSize = 30.sp)
        Text(text = "JetPack", fontSize = 30.sp)
        Text(text = "Last", fontSize = 30.sp)
    }
}

@Composable
fun ColumnExample() {

    Column(
        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
            .fillMaxSize() //0.5f Fraction ke liya if karna ho to.
            .background(color = Color.Gray)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "first", fontSize = 30.sp)
        for (i in 0..100) {
            Text(text = "Item is $i", fontSize = 30.sp)
        }
        Text(text = "Last", fontSize = 30.sp)
    }
}

@Composable
fun LazyRowExample() {

    LazyRow(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 100.dp),
        horizontalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        //Add single Item
        item { Text(text = "First Item", fontSize = 30.sp) }
        //Add a multiline Item
        items(50) { i -> Text(text = " Item $i ", fontSize = 30.sp) }
        //Add a single Item
        item { Text(text = "Last Item", fontSize = 30.sp) }
    }
}

@Composable
fun LazyRowColumn() {

    LazyColumn(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        //Add single Item
        item { Text(text = "First Item", fontSize = 30.sp) }
        //Add a multiline Item
        items(50) { i -> Text(text = " Item $i ", fontSize = 30.sp) }
        //Add a single Item
        item { Text(text = "Last Item", fontSize = 30.sp) }
    }
}

@Composable
fun boxExample() {

    Box(
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth(.5f)
            .fillMaxHeight(.5f)
    ) {
        Text(text = "This is outer box......")
        Box(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth(.5f)
                .fillMaxHeight(.5f)
        ) {
            Text(
                text = "This is inner box.....",
                color = Color.Cyan,
                modifier = Modifier.align(Alignment.Center),
            )
        }
        Text(text = "This is box", color = Color.Red, modifier = Modifier.align(Alignment.Center))

    }
}

@Composable
fun MaterialUiApp() {
}

@Composable
fun ImageAssetExample() {

    Image(
        painter = painterResource(id = R.drawable.anime),
        contentDescription = "About",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .border(5.5.dp, Color.Red, CircleShape)
            .size(300.dp)
            .clip(shape = CircleShape)
    )
}

@Composable
fun ImageInternetExample() {
    Image(
        painter = rememberImagePainter(
            data = "https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png"
        ),
        contentDescription = "About",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .border(5.5.dp, Color.Red, CircleShape)
            .size(300.dp)
            .clip(shape = CircleShape)
    )
}

@Composable
fun IconExample() {
    Icon(
        Icons.Filled.Menu,
        contentDescription = "Menu",
        modifier = Modifier.size(50.dp),
        tint = Color.Red
    )
}

@Composable
fun CardExample() {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Gray,
        border = BorderStroke(5.dp, Color.Red)
    ) {
        Column(modifier = Modifier.padding(40.dp)) {
            Text(
                text = "This is Card....",
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Jetpack",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun StatefulExample() {
    var name: String by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(value = name, onValueChange = { name = it })
        Text(text = name, fontSize = 30.sp)
    }
}

//State Hosting
@Composable
fun HelloScreen() {
    var name: String by remember { mutableStateOf("") }
    HelloContent(name = name, onNameChange = { name = it })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column {
        OutlinedTextField(value = name, onValueChange = onNameChange)
        Text(text = name, fontSize = 30.sp)
    }
}

@Composable
fun ButtonsExample() {

    Column {

        Button(
            onClick = {
                Log.d("Button", "Button Clicked")
            },
            modifier = Modifier.padding(30.dp),
            contentPadding = PaddingValues(start = 40.dp, top = 20.dp, end = 40.dp, bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            shape = CircleShape,
            border = BorderStroke(5.dp, Color.Blue)
        ) {
            Text(text = "Button", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextFieldExample() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        item {
            TextField(value = "",
                onValueChange = {}, label = { Text(text = "Name") },
                placeholder = { Text(text = "Write your Name") },
                textStyle = TextStyle(color = Color.Blue),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = ""

                    )
                },
                shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Green, unfocusedIndicatorColor = Color.Transparent
                ),
//                readOnly = true,
//                singleLine = true,
            )
        }
//        item {  }
    }

}