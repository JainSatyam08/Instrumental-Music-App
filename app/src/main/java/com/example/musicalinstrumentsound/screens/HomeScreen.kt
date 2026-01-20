package com.example.musicalinstrumentsound.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.musicalinstrumentsound.R
import com.example.musicalinstrumentsound.components.InstrumentCard
import com.example.musicalinstrumentsound.components.TopHeading
import com.example.musicalinstrumentsound.ui.theme.Instrument

@Composable
fun HomeScreen(onInstrumentClick: (String) -> Unit) {
    val instruments = listOf(
        Instrument("Classical", R.drawable.ic_classical, Color.Red),
        Instrument("Pop", R.drawable.ic_pop, Color.Yellow),
        Instrument("Relaxing", R.drawable.ic_relaxing, Color.Green),
        Instrument("Sad", R.drawable.ic_sad, Color.Blue),
        Instrument("Motivational", R.drawable.ic_motivational, Color.Magenta)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        TopHeading()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(instruments) { instrument ->
                InstrumentCard(instrument,
                    onClick = { onInstrumentClick(instrument.name) })
            }
        }
    }
}