package com.example.countriescomposed

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DetailsScreen(viewModel: CountriesViewModel) {

    Row {
        Box(
            modifier = Modifier
                .size(150.dp) // Adjust image size as needed
                .border(
                    width = 4.dp, // Adjust border width as needed
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp) // Adjust corner radius as needed
                )
        ) {
            AsyncImage(
                model = viewModel.countries.get(viewModel.clickedCountry).flags?.png,
                contentDescription = "Flag of ${
                    viewModel.countries.get(viewModel.clickedCountry).name.toString()

                }",
                modifier = Modifier
                    .fillMaxSize()

            )
        }
        /*Column {
            Text(text = viewModel.countries.get(viewModel.clickedCountry).name?.common.toString(),
            style = MaterialTheme.typography.subtitle1)
            Row {
                Text(text = "Population", style = MaterialTheme.typography.caption)
                Text(text = viewModel.countries.get(viewModel.clickedCountry).population.toString())
            }
            Row {
                Text(text = "Capital", style = MaterialTheme.typography.caption)
                Text(text = viewModel.countries.get(viewModel.clickedCountry).capital[0])
            }

        }*/Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = viewModel.countries.get(viewModel.clickedCountry).name?.common.toString(),
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val populationLabel = "Population"
        val populationValue =
            viewModel.countries.get(viewModel.clickedCountry).population.toString()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 4.dp)
        ) {
            Text(
                text = populationLabel,
                style = MaterialTheme.typography.caption.copy(color = Color.Gray),
                modifier = Modifier.width(80.dp) // Adjust width as needed
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = populationValue,
                style = MaterialTheme.typography.body1.copy(color = Color.Black)
            )
        }

        val capitalLabel = "Capital"
        val capitalValue = viewModel.countries.get(viewModel.clickedCountry).capital[0]
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 4.dp)
        ) {
            Text(
                text = capitalLabel,
                style = MaterialTheme.typography.caption.copy(color = Color.Gray),
                modifier = Modifier.width(80.dp) // Adjust width as needed
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = capitalValue,
                style = MaterialTheme.typography.body1.copy(color = Color.Black)
            )
        }
    }
    }
}