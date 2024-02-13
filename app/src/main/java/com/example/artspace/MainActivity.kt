package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentImage by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentImage) {
            1 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.black_square,
                    nameResource = R.string.black_square,
                    authorResource = R.string.black_square_author,
                    onNextButtonClick = { currentImage = 2 },
                    onPreviousButtonClick = { currentImage = 4 })
            }
            2 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.cry,
                    nameResource = R.string.the_scream,
                    authorResource = R.string.the_scream_author,
                    onNextButtonClick = { currentImage = 3 },
                    onPreviousButtonClick = { currentImage = 1 })
            }
            3 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.mona_liza,
                    nameResource = R.string.mona_liza,
                    authorResource = R.string.mona_liza_author,
                    onNextButtonClick = { currentImage = 4 },
                    onPreviousButtonClick = { currentImage = 2 })
            }
            4 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.the_last_supper,
                    nameResource = R.string.the_last_supper,
                    authorResource = R.string.the_last_supper_author,
                    onNextButtonClick = { currentImage = 1 },
                    onPreviousButtonClick = { currentImage = 3 })
            }
        }
    }
}

@Composable
fun ArtSpaceImage(
    imageResource: Int,
    nameResource: Int,
    authorResource: Int,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ){
            Surface(
                //elevation = 16.dp,
                border = BorderStroke(3.dp, color = Color.LightGray)
            ){
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier.padding(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
               // elevation = 15.dp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp, 16.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(nameResource),
                        modifier = Modifier
                            .padding(16.dp, 16.dp, 16.dp, 0.dp),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.allerta))
                    )
                    Text(
                        text = stringResource(authorResource),
                        modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.allerta, weight = FontWeight.ExtraBold)))
                }
            }
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp, 16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = { onPreviousButtonClick() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = stringResource(R.string.previous))
                }
                Button(
                    onClick = { onNextButtonClick() },
                    modifier = Modifier.padding(8.dp)
                ){
                    Text(text = stringResource(R.string.next), Modifier.padding(12.dp,0.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}