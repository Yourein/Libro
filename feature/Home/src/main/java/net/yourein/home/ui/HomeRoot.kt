package net.yourein.home.ui

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import net.yourein.datasource.entities.Book
import net.yourein.feature.home.R
import net.yourein.home.HomeViewModel
import net.yourein.librocore.theme.LibroTheme

@Composable
fun HomeRoot(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeRoot(
        scrollState = rememberScrollState(),
        currentlyReadingBooks = homeViewModel.currentlyReadingBooks,
        recentlyAddedBooks = homeViewModel.recentlyAddedBooks,
        onBooksClicked = { /*TODO*/ },
        onSeriesClicked = { /*TODO*/ },
        onAuthorsClicked = { /*TODO*/ },
        onTagsClicked = { /*TODO*/ },
        getBookThumbnail = {
            homeViewModel.getBookThumbnail(book = it)
        },
        onRecentlyAddedBookThumbnailClicked = {},
    )
}

@Composable
fun HomeRoot(
    scrollState: ScrollState,
    currentlyReadingBooks: ImmutableList<Book>,
    recentlyAddedBooks: ImmutableList<Book>,
    onBooksClicked: () -> Unit,
    onSeriesClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
    onTagsClicked: () -> Unit,
    getBookThumbnail: @Composable (Book) -> Painter?,
    onRecentlyAddedBookThumbnailClicked: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(18.dp)
    ) {
        Text(
            text = stringResource(id = R.string.home),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        HomeNavigationStack(
            onBooksClicked = onBooksClicked,
            onSeriesClicked = onSeriesClicked,
            onAuthorsClicked = onAuthorsClicked,
            onTagsClicked = onTagsClicked
        )

        Text(
            text = stringResource(id = R.string.continue_reading),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        @OptIn(ExperimentalFoundationApi::class)
        CurrentlyReadingList(
            bookList = currentlyReadingBooks,
            pagerState = rememberPagerState {
                currentlyReadingBooks.size
            },
            getBookThumbnail = getBookThumbnail,
            onBookClicked = {},
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = stringResource(id = R.string.recently_added),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        RecentlyAddedList(
            books = recentlyAddedBooks,
            getBookThumbnail = getBookThumbnail,
            onBookThumbnailClicked = onRecentlyAddedBookThumbnailClicked,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF101010,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun HomeRootPreview() {
    LibroTheme {
        HomeRoot(
            scrollState = rememberScrollState(),
            currentlyReadingBooks = persistentListOf(),
            recentlyAddedBooks = persistentListOf(),
            onBooksClicked = {  },
            onSeriesClicked = {  },
            onAuthorsClicked = {  },
            onTagsClicked = {  },
            getBookThumbnail = { null },
            onRecentlyAddedBookThumbnailClicked = {},
        )
    }
}