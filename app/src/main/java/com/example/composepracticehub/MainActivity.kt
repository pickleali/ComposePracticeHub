package com.example.composepracticehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.AndroidPaint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepracticehub.ui.theme.ComposePracticeHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val firstImage = painterResource(id = R.drawable.redbull_1)
            val secondImage = painterResource(id = R.drawable.redbull_2)
            val description = "RedBull at sunset"
            Row() {
                Column() {
                    ImageCardF1(painter = firstImage, contentDescription = description , title = description)
                    ImageCardF1(painter = secondImage, contentDescription = description , title = description)
                    ImageCardF1(painter = firstImage, contentDescription = description , title = description)
//                    ImageCardF1(painter = secondImage, contentDescription = description , title = description)
                }
            }

        }
    }

}

@Composable
fun ImageCardF1(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Spacer(Modifier.padding(vertical = 5.dp))
    Box(modifier = Modifier.fillMaxWidth(0.5f)) {

        Card(
            // modifier here is passed as a parameter from the arguments of ImageCardF1() fun
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            // Box() is used to control the alignment of the items (also have other applications)
            // For example: this card item will contain as layers --> 1-Image. 2-Gradient. 3-Text.
            Box(modifier =  Modifier.height(200.dp)) { //modifier = (M)odifier because we want to create another Modifier object.
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop//to crop the image and fit the Box
                )
                //gradient box
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.LightGray
                                ),
                                startY = 400f //hard-coded for this code (not repsonsive)
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        title,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    )

                }

            }


        }
    }
    Spacer(Modifier.padding(vertical = 5.dp))
}