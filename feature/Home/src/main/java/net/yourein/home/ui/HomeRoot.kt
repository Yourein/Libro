package net.yourein.home.ui

import android.content.res.Configuration
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.yourein.feature.home.R
import net.yourein.home.HomeViewModel
import net.yourein.librocore.theme.LibroTheme

@Composable
fun HomeRoot(
    homeViewModel: HomeViewModel = viewModel()
) {


    HomeRoot(
        scrollableState = rememberScrollState(),
        onBooksClicked = { /*TODO*/ },
        onSeriesClicked = { /*TODO*/ },
        onAuthorsClicked = { /*TODO*/ },
        onTagsClicked = { /*TODO*/ },
    )
}

@Composable
fun HomeRoot(
    scrollableState: ScrollableState,
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
            onBooksClicked = { /*TODO*/ },
            onSeriesClicked = { /*TODO*/ },
            onAuthorsClicked = { /*TODO*/ },
            onTagsClicked = { /*TODO*/ },
        )
    }
}