package com.example.musicalinstrumentsound

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicalinstrumentsound.ui.theme.InsrtumentNavHost
import com.example.musicalinstrumentsound.ui.theme.MusicalInstrumentSoundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicalInstrumentSoundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InsrtumentNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}
