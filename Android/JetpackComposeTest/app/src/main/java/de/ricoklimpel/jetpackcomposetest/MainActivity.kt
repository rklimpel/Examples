package de.ricoklimpel.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mockTodos = getMockTodos()
            TodoList(todos = mockTodos)
        }
    }
}

data class Todo(var text: String, var checked: Boolean, var creationDate: String)

fun getMockTodos(): List<Todo> {
    return listOf(
        Todo("Clean my room",false,"12.04.2021"),
        Todo("code a cool app",true,"16.05.2021"),
        Todo("Write a tweet about birds",false,"01.01.2020"),
        Todo("go shopping",false,"02.05.2021"),
        Todo("buy butter",true,"21.07.2021"),
        Todo("send a message to my friend about the best olympic sport", false, "07.08.2021"),
        Todo("This is a long text inside a todo note and this note will fill more than one line",true, "09.08.2021")
    )
}

@Composable
fun TodoItemView(todo: Todo) {

    Column(modifier = Modifier.padding(all = 8.dp)) {
        Card (modifier =  Modifier.fillMaxWidth().border(1.dp, Color.Black), elevation = 4.dp) {
            Column (modifier = Modifier.padding(all = 8.dp)) {
                var checkedState = remember { mutableStateOf(todo.checked) }
                Text(text = todo.text, fontSize = 30.sp)
                Text(text = todo.creationDate)
                Checkbox(checked = checkedState.value, onCheckedChange = {checkState -> checkedState.value = checkState})
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn{
        items(todos) { todo ->
            TodoItemView(todo = todo)
        }
    }
}