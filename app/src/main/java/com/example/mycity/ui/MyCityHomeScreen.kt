package com.example.mycity

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.datasource.dataSource


@Composable
fun MyCityHomeScreen() {

    val cityCategories = dataSource.cityCatories;
    LazyColumn {
        items(cityCategories) {
            Text(text = stringResource(id = it.name))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCityHomeScreenPreview() {
    MyCityHomeScreen()
}
