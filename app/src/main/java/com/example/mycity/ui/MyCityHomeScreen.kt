package com.example.mycity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.datasource.dataSource
import com.example.mycity.model.Category


@Composable
fun MyCityHomeScreen() {

    val cityCategories = dataSource.cityCatories
    LazyColumn {
        items(cityCategories) {
            MyCityCategoryItem(category = it)
        }
    }
}
@Composable
fun MyCityCategoryItem(category: Category){
    Row(){
        Image(painter = painterResource(id = category.imageResourceId), contentDescription = null)
        Text(text = stringResource(id = category.name))
    }
}

@Preview(showBackground = true)
@Composable
fun MyCityHomeScreenPreview() {
    MyCityHomeScreen()
}
