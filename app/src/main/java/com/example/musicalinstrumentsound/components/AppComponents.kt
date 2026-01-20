package com.example.musicalinstrumentsound.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicalinstrumentsound.R
import com.example.musicalinstrumentsound.ui.theme.DeepWineRed
import com.example.musicalinstrumentsound.ui.theme.Instrument
import com.example.musicalinstrumentsound.ui.theme.Song
import com.example.musicalinstrumentsound.ui.theme.TextWhite

@Composable
fun InstrumentCard(instrument: Instrument, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(instrument.color.copy(alpha = 0.3f), instrument.color)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = instrument.image),
                    contentDescription = instrument.name,
                    modifier = Modifier
                        .size(85.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = instrument.name,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun TopHeading(
    color: Color = DeepWineRed
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(160.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(color.copy(alpha = 0.3f), color)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Greetings User!!",
                        style = MaterialTheme.typography.headlineMedium,
                        color = TextWhite
                    )
                    Text(
                        text = "Wants To Relax??",
                        style = MaterialTheme.typography.headlineSmall,
                        color = TextWhite
                    )
                    Text(
                        text = "Here Enjoy !! ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextWhite
                    )
                    Text(
                        text = "Your Favourite Instrumental Beats!!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextWhite
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.music_note),
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SongItem(song: Song,isPlaying: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.music_note),
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = song.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = song.artist, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

