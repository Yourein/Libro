package net.yourein.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import net.yourein.datasource.entities.Book
import net.yourein.feature.home.R
import net.yourein.librocore.theme.LibroTheme
import net.yourein.librocore.uiparts.DummyBookThumbnail

@Composable
fun RecentlyAddedList(
    books: ImmutableList<Book>,
    getBookThumbnail: @Composable (Book) -> Painter?,
    onBookThumbnailClicked: (Int) -> Unit, //Expected to jump to the book page
) {
    if (books.size == 0) {
        EmptyRecentAddedListItem()
    }
    else {
        @OptIn(ExperimentalLayoutApi::class)
        FlowRow(
            horizontalArrangement = Arrangement.SpaceEvenly,
            maxItemsInEachRow = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            val itemHeight = 140.dp
            repeat(books.size) { index ->
                RecentlyAddedBook(
                    bookThumbnail = getBookThumbnail(books[index]),
                    itemHeight = itemHeight,
                    modifier = Modifier
                        .padding(4.dp)
                        .height(itemHeight)
                        .clickable {
                            onBookThumbnailClicked(books[index].id)
                        }
                )
            }
        }
    }
}

@Composable
private fun EmptyRecentAddedListItem() {
    Text(
        text = stringResource(id = R.string.no_recently_added),
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    )
}

@Composable
private fun RecentlyAddedBook(
    bookThumbnail: Painter?,
    itemHeight: Dp,
    modifier: Modifier,
) {
    if (bookThumbnail == null) {
        DummyBookThumbnail(
            modifier = modifier
                .width((itemHeight/1.4142.dp).dp)
        )
    }
    else {
        Image(
            painter = bookThumbnail,
            contentDescription = null,
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    device = Devices.PIXEL_7A
)
@Composable
private fun RecentlyAddedListPreview1() {
    LibroTheme {
        RecentlyAddedList(
            books = persistentListOf(),
            getBookThumbnail = { null },
            onBookThumbnailClicked = {},
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    device = Devices.PIXEL_7A
)
@Composable
private fun RecentlyAddedListPreview2() {
    val bookList = (1..12).map {
        Book(
            name = "Title",
            readingStatus = 0,
            isbn = "",
            publishDate = "",
            thumbnailName = "",
            thumbnailUrl = "",
            registeredAt = 0
        )
    }.toImmutableList()

    LibroTheme {
        RecentlyAddedList(
            books = bookList,
            getBookThumbnail = { null },
            onBookThumbnailClicked = {},
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    device = Devices.PIXEL_7A
)
@Composable
private fun RecentlyAddedListPreview3() {
    val bookList = (1..12).map {
        Book(
            name = "Title",
            readingStatus = 0,
            isbn = "",
            publishDate = "",
            thumbnailName = "",
            thumbnailUrl = "",
            registeredAt = 0
        )
    }.toImmutableList()

    LibroTheme {
        RecentlyAddedList(
            books = bookList,
            getBookThumbnail = { painterResource(id = R.drawable.small_sample_thumbnail_a6) },
            onBookThumbnailClicked = {},
        )
    }
}