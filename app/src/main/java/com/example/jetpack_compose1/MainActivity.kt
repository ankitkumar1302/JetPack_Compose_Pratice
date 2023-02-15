package com.example.jetpack_compose1

import android.os.Bundle
import android.text.Selection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose1.ui.theme.MyFontFamily

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
        item { Text (text= "Last Item", fontSize = 30.sp) }
    }
}
//@Composable
//fun LazyRowColumn(){
//
//    LazyColumn(
//        modifier = Modifier.background(color = Color.Gray)
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 100.dp),
//        verticalArrangement = Arrangement.spacedBy(50.dp)
//    ){
//        //Add single Item
//        item { Text(text = "First Item", fontSize = 30.sp) }
//        //Add a multiline Item
//        items(50) { i -> Text(text = " Item $i ", fontSize = 30.sp) }
//        //Add a single Item
//        item { Text (text= "Last Item", fontSize = 30.sp) }
//    }
//}
