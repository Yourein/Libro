package net.yourein.home.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import net.yourein.datasource.entities.Book
import net.yourein.feature.home.R
import net.yourein.librocore.theme.LibroPrimary
import net.yourein.librocore.theme.LibroTheme
import net.yourein.librocore.uiparts.DummyBookThumbnail

@Composable
fun CurrentlyReadingList(
    bookList: ImmutableList<Book>,
    @OptIn(ExperimentalFoundationApi::class)
    pagerState: PagerState,
    getBookThumbnail: @Composable (Book) -> Painter?,
    onBookClicked: (Int) -> Unit,
) {
    if (bookList.isEmpty()) {
        CurrentlyReadingEmptyItem(
            itemWidth = LocalConfiguration.current.screenWidthDp.dp - 36.dp
        )
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            @OptIn(ExperimentalFoundationApi::class)
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(16.dp),
                pageSpacing = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) { pageIndex ->
                CurrentlyReadingListItem(
                    book = bookList[pageIndex],
                    bookThumbnail = getBookThumbnail(bookList[pageIndex]),
                    itemWidth = LocalConfiguration.current.screenWidthDp.dp - 36.dp,
                    onItemClicked = onBookClicked
                )
            }

            @OptIn(ExperimentalFoundationApi::class)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 2.dp)
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) LibroPrimary else Color(
                            0xFF303030
                        )
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(6.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CurrentlyReadingListItem(
    book: Book,
    bookThumbnail: Painter?,
    itemWidth: Dp,
    onItemClicked: (Int) -> Unit,
) {
    val itemHeight = itemWidth * (1F / 4F)
    val thumbnailHeight = itemHeight - 16.dp
    val thumbnailWidth = thumbnailHeight * (1F / 1.41F)

    BoxWithConstraints(
        modifier = Modifier
            .clickable { onItemClicked(book.id) }
            .size(itemWidth, itemHeight)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRoundRect(
                color = Color(0xFF303030),
                cornerRadius = CornerRadius(12F, 12F)
            )
        }

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            if (bookThumbnail == null) {
                DummyBookThumbnail(
                    modifier = Modifier
                        .size(thumbnailWidth, thumbnailHeight)
                )
            } else {
//                AsyncImage(
//                    model = bookThumbnail,
//                    contentDescription = null,
//                    modifier = Modifier.height(thumbnailHeight)
//                )
                Image(
                    painter = bookThumbnail,
                    contentDescription = null
                )
            }

            Spacer(Modifier.width(8.dp))

            Text(
                text = book.name,
                fontSize = 18.sp,
                lineHeight = 21.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 4.dp)
        ) {
            Text(
                text = stringResource(id = R.string.edit_reading_status),
                fontSize = 11.sp
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .height(itemHeight / 4),
                tint = LibroPrimary,
            )
        }
    }
}

@Composable
private fun CurrentlyReadingEmptyItem(
    itemWidth: Dp,
) {
    val itemHeight = itemWidth * (1F / 4F)

    BoxWithConstraints(
        modifier = Modifier
            .size(itemWidth, itemHeight)
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRoundRect(
                color = Color(0xFF303030),
                cornerRadius = CornerRadius(12F, 12F)
            )
        }

        Text(
            text = stringResource(id = R.string.no_currently_reading),
            fontSize = 16.sp,
            lineHeight = 19.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)
@Composable
private fun ReadingListPreview1() {
    val book = Book(
        name = "Title",
        readingStatus = 0,
        isbn = "",
        publishDate = "",
        thumbnailName = "",
        thumbnailUrl = "",
        registeredAt = 0
    )

    LibroTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            @OptIn(ExperimentalFoundationApi::class)
            CurrentlyReadingList(
                bookList = persistentListOf(book, book, book),
                getBookThumbnail = { null },
                onBookClicked = {},
                pagerState = rememberPagerState {
                    3
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)
@Composable
private fun ReadingListPreview2() {
    LibroTheme {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            @OptIn(ExperimentalFoundationApi::class)
            CurrentlyReadingList(
                bookList = persistentListOf(),
                getBookThumbnail = { null },
                onBookClicked = {},
                pagerState = rememberPagerState {
                    3
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun ReadingItemPreview1() {
    val book = Book(
        name = "Title",
        readingStatus = 0,
        isbn = "",
        publishDate = "",
        thumbnailName = "",
        thumbnailUrl = "",
        registeredAt = 0
    )

    LibroTheme {
        CurrentlyReadingListItem(
            book = book,
            bookThumbnail = null,
            itemWidth = 360.dp,
            onItemClicked = {},
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun ReadingItemPreview2() {
    val book = Book(
        name = "TitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitle",
        readingStatus = 0,
        isbn = "",
        publishDate = "",
        thumbnailName = "",
        thumbnailUrl = "",
        registeredAt = 0
    )

    LibroTheme {
        CurrentlyReadingListItem(
            book = book,
            bookThumbnail = null,
            itemWidth = 360.dp,
            onItemClicked = {},
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun ReadingEmptyItemPreview() {
    LibroTheme {
        CurrentlyReadingEmptyItem(itemWidth = 360.dp)
    }
}