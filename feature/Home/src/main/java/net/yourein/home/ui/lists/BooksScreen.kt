package net.yourein.home.ui.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.ImmutableList
import net.yourein.datasource.entities.Book
import net.yourein.home.BooksScreenViewModel
import net.yourein.librocore.LocalNavigationController
import net.yourein.librocore.uiparts.DummyBookThumbnail

@Composable
fun BooksScreen(
    viewModel: BooksScreenViewModel = hiltViewModel(),
) {
    // 後に本のdetailに飛べるようにする
    val navController = LocalNavigationController.current

    BooksScreen(
        bookList = viewModel.allBooksList,
        lazyColumnState = viewModel.lazyListState,
        onClickedBackArrow = {
            navController.findNavController().popBackStack()
        },
        onBookClicked = {  },
        getBookthumbnail = { book ->
            viewModel.getBookThumbnail(book = book)
        },
    )
}

@Composable
private fun BooksScreen(
    bookList: ImmutableList<Book>,
    lazyColumnState: LazyListState,
    onClickedBackArrow: () -> Unit,
    onBookClicked: (Int) -> Unit,
    getBookthumbnail: @Composable (Book) -> Painter?
) {
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = {
                    Text(
                        text = "Books"
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable {
                                onClickedBackArrow()
                            }
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            state = lazyColumnState,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            items(bookList) { book ->
                BookItem(
                    book = book,
                    onBookClicked = onBookClicked,
                    bookThumbnail = getBookthumbnail(book),
                )

                if (book != bookList.last()) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun BookItem(
    book: Book,
    onBookClicked: (Int) -> Unit,
    bookThumbnail: Painter?,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onBookClicked(book.id)
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        if (bookThumbnail == null) {
            DummyBookThumbnail(
                modifier = Modifier
                    .height(90.dp)
                    .aspectRatio(1/1.41F)
            )
        } else {
            Image(
                painter = bookThumbnail,
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .aspectRatio(1/1.41F)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = book.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}