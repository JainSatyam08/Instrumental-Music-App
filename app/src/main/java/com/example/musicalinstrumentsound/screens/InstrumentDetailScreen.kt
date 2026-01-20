package com.example.musicalinstrumentsound.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicalinstrumentsound.R
import com.example.musicalinstrumentsound.components.SongItem
import com.example.musicalinstrumentsound.ui.theme.Song

@Composable
fun InstrumentDetailScreen(instrumentName: String) {
    // Dynamically choose songs based on instrument name for better UX
    val context = androidx.compose.ui.platform.LocalContext.current
    val mediaPlayer = remember { android.media.MediaPlayer() }
    var playingSongTitle by remember { androidx.compose.runtime.mutableStateOf<String?>(null) }
    var isPlaying by remember { androidx.compose.runtime.mutableStateOf(false) }
    val playAudio = { song: Song ->
        try {
            mediaPlayer.reset()
            val assetFileDescriptor = context.resources.openRawResourceFd(song.audioResId)
            mediaPlayer.setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length
            )
            assetFileDescriptor.close()
            mediaPlayer.prepare()
            mediaPlayer.start()
            playingSongTitle = song.title
            isPlaying = true

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    val togglePlayPause = {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            isPlaying = false
        } else {
            mediaPlayer.start()
            isPlaying = true
        }
    }
    val songList = when (instrumentName) {
        "Classical" -> listOf(
            Song("Indian Classical 1", "Traditional", R.raw.indian_classical_one),
            Song("Indian Classical 2", "Traditional", R.raw.indian_classical_two),
            Song("Indian Classical 3", "Traditional", R.raw.indian_classical_three),
            Song("Indian Classical 4", "Traditional", R.raw.indian_classical_four),
            Song("Indian Classical 5", "Traditional", R.raw.indian_classical_five),
            Song("Indian Classical 6", "Traditional", R.raw.indian_classical_six),
            Song("Indian Classical 7", "Traditional", R.raw.indian_classical_eight),
            Song("Indian Classical 8", "Traditional", R.raw.indian_classical_nine)
        )

        "Pop" -> listOf(
            Song("Upbeat Pop 1", "Modern", R.raw.upbeat_pop_one),
            Song("Upbeat Pop 2", "Modern", R.raw.upbeat_pop_two),
            Song("Upbeat Pop 3", "Modern", R.raw.upbeat_pop_three),
            Song("Upbeat Pop 4", "Modern", R.raw.upbeat_pop_four),
            Song("Upbeat Pop 5", "Modern", R.raw.upbeat_pop_five),
            Song("Upbeat Pop 6", "Modern", R.raw.upbeat_pop_six),
            Song("Upbeat Pop 7", "Modern", R.raw.upbeat_pop_seven),
            Song("Upbeat Pop 8", "Modern", R.raw.upbeat_pop_eight),
            Song("Upbeat Pop 9", "Modern", R.raw.upbeat_pop_nine)
        )

        "Relaxing" -> listOf(
            Song("Relaxing Calm 1", "Soothing", R.raw.piano_one_calm),
            Song("Relaxing Calm 2", "Soothing", R.raw.piano_two_calm),
            Song("Relaxing Calm 3", "Soothing", R.raw.piano_three_calm),
            Song("Relaxing Calm 4", "Soothing", R.raw.piano_four_emptional),
            Song("Relaxing Calm 5", "Soothing", R.raw.piano_five_solo),
            Song("Relaxing Calm 6", "Soothing", R.raw.piano_six_inspire)
        )

        "Sad" -> listOf(
            Song("Sad Melody 1", "Emotional", R.raw.sad_one),
            Song("Sad Melody 2", "Emotional", R.raw.sad_two),
            Song("Sad Melody 3", "Emotional", R.raw.sad_three),
            Song("Sad Melody 4", "Emotional", R.raw.sad_four),
            Song("Sad Melody 5", "Emotional", R.raw.sad_five),
            Song("Sad Melody 6", "Emotional", R.raw.sad_six),
            Song("Sad Melody 7", "Emotional", R.raw.sad_seven),
            Song("Sad Melody 8", "Emotional", R.raw.sad_eight),
            Song("Sad Melody 9", "Emotional", R.raw.sad_nine)
        )

        "Motivational" -> listOf(
            Song("Inspirations 1", "Nature", R.raw.motivational_one),
            Song("Inspirations 2", "Nature", R.raw.motivational_two),
            Song("Inspirations 3", "Nature", R.raw.motivational_three),
            Song("Inspirations 4", "Nature", R.raw.motivational_four),
            Song("Inspirations 5", "Nature", R.raw.motivational_five),
            Song("Inspirations 6", "Nature", R.raw.motivational_six),
            Song("Inspirations 7", "Nature", R.raw.motivational_seven),
            Song("Inspirations 8", "Nature", R.raw.motivational_eight),
            Song("Inspirations 9", "Nature", R.raw.motivational_nine),

            )

        else -> listOf(
            Song("Peaceful Melody", "Instrumental", R.raw.indian_classical_six),
            Song("Deep Focus", "Relaxing", R.raw.piano_four_emptional)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Text(
            text = "$instrumentName Sounds",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(songList) { song ->
                SongItem(
                    song = song,
                    isPlaying = playingSongTitle == song.title,
                    onClick = { playAudio(song) })
            }
        }
        if (playingSongTitle != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF222222)),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Now Playing", color = Color.Gray, fontSize = 12.sp)
                        Text(
                            text = playingSongTitle!!,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Icon(
                        painter = painterResource(
                            id = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
                        ),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { togglePlayPause() }
                    )
                }

            }
        }
    }
    androidx.compose.runtime.DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release() // App memory release kar dega
        }
    }
}