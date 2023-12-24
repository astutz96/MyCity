package com.example.mycity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun MyCityCategoryItem(category: Category) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = category.imageResourceId), contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = category.name),
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyCityHomeScreenPreview() {
    MyCityHomeScreen()
}
