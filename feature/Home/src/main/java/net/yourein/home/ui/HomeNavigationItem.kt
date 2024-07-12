package net.yourein.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.yourein.librocore.theme.LibroPrimary

@Composable
fun HomeNavigationItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = LibroPrimary,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = LibroPrimary,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeNavigationItemPreview1() {
    HomeNavigationItem(
        title = "AccountBox",
        icon = Icons.Filled.AccountBox,
        onClick = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeNavigationItemPreview2() {
    HomeNavigationItem(
        title = "Extremely Looooong Looooong Title For The Preview",
        icon = Icons.Filled.AccountBox,
        onClick = {},
    )
}