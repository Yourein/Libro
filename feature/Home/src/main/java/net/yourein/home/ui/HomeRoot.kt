package net.yourein.home.ui

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        scrollableState = rememberScrollState(),
        currentlyReadingBooks = homeViewModel.currentlyReadingBooks,
        onBooksClicked = { /*TODO*/ },
        onSeriesClicked = { /*TODO*/ },
        onAuthorsClicked = { /*TODO*/ },
        onTagsClicked = { /*TODO*/ },
    )
}

@Composable
fun HomeRoot(
    scrollableState: ScrollableState,
    currentlyReadingBooks: ImmutableList<Book>,
    onBooksClicked: () -> Unit,
    onSeriesClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
    onTagsClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollableState,
                orientation = Orientation.Vertical
            )
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
            getBookThumbnail = { null },
            onBookClicked = {},
        )

        Text(
            text = stringResource(id = R.string.recently_added),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
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
            scrollableState = rememberScrollState(),
            currentlyReadingBooks = persistentListOf(),
            onBooksClicked = { /*TODO*/ },
            onSeriesClicked = { /*TODO*/ },
            onAuthorsClicked = { /*TODO*/ },
            onTagsClicked = { /*TODO*/ },
        )
    }
}