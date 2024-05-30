package net.yourein.home.ui.lists

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.ImmutableList
import net.yourein.datasource.entities.Book
import net.yourein.home.BooksScreenViewModel
import net.yourein.librocore.LocalNavigationController

@Composable
fun BooksScreen(
    viewModel: BooksScreenViewModel = hiltViewModel()
) {
    // 後に本のdetailに飛べるようにする
    val navController = LocalNavigationController.current

    BooksScreen(
        bookList = viewModel.allBooksList,
        onBookClicked = { }
    )
}

@Composable
private fun BooksScreen(
    bookList: ImmutableList<Book>,
    onBookClicked: (Int) -> Unit,
) {
    LazyColumn {
        items(bookList) { book ->
            BookItem(book, onBookClicked)
        }
    }
}

@Composable
private fun BookItem(
    book: Book,
    onBookClicked: (Int) -> Unit
) {
    Row {
        Text("TODO")
    }
}