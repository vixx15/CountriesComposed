package com.example.countriescomposed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.countries.dto.Countries


@Composable
fun MainScreen(viewModel: CountriesViewModel = viewModel(), navController: NavController) {
    viewModel.getCountriesFromAPI()

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )
    {
        itemsIndexed(items = viewModel.countries) { index, country ->
            ListItem(country = country,
                viewModel = viewModel,
                onItemClick = {
                    viewModel.clickedCountry = index
                    navController.navigate(Screens.DetailScreen.route)
                }
            )
        }


    }

}

@Composable
fun ListItem(country: Countries, viewModel: CountriesViewModel, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row() {
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = country.name?.common.toString(), style = typography.titleMedium)
                Text(text = "VIEW DETAIL", style = typography.bodyMedium)
            }
        }
    }
}

