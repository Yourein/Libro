package net.yourein.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.yourein.librocore.theme.LibroDivider

@Composable
fun HomeNavigationStack(
    onBooksClicked: () -> Unit,
    onSeriesClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
    onTagsClicked: () -> Unit,
) {
    // それぞれのitemに入れてるiconは仮

    HorizontalDivider(
        color = LibroDivider,
        thickness = 1.dp,
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 6.dp
        )
    )
    HomeNavigationItem(
        title = "Books",
        icon = Icons.Filled.Add,
        onClick = onBooksClicked,
    )
    HorizontalDivider(
        color = LibroDivider,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 6.dp)
    )
    HomeNavigationItem(
        title = "Series",
        icon = Icons.Filled.Add,
        onClick = onSeriesClicked,
    )
    HorizontalDivider(
        color = LibroDivider,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 6.dp)
    )
    HomeNavigationItem(
        title = "Authors",
        icon = Icons.Filled.Add,
        onClick = onAuthorsClicked,
    )
    HorizontalDivider(
        color = LibroDivider,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 6.dp)
    )
    HomeNavigationItem(
        title = "Tags",
        icon = Icons.Filled.Add,
        onClick = onTagsClicked,
    )
    HorizontalDivider(
        color = LibroDivider,
        thickness = 1.dp,
        modifier = Modifier.padding(
            top = 6.dp,
            bottom = 16.dp
        )
    )
}