package com.devio.smartknobview.ui.compose

import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.devio.smartknobview.R
import com.devio.smartknobview.ui.shape.KnobShape

@Composable
fun SmartKnobView(
    modifier: Modifier = Modifier,
    rotationDegrees: Float = 0f
) {
    Box(
        modifier = modifier
            .aspectRatio(1.0f)
//            .clip(KnobShape())
    ) {
        // Vinyl background
        Image(
            modifier = Modifier
                .fillMaxSize()
                .rotate(rotationDegrees)
                .clip(KnobShape()),
            painter = painterResource(id = R.drawable.amazon_echodot),
            contentDescription = ""
        )
        Column(modifier = Modifier.align(Alignment.Center)){
            Text(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),text =rotationDegrees.toInt().toString().toString(), color = Color.White)

            Text( modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),text = if(rotationDegrees>=-15 && rotationDegrees<10){
                "Bounded.No Dents"}
            else if(rotationDegrees>=10&& rotationDegrees<15){
                "Course.Strong Dents"
            }else{
                 ""
            }
                , color = Color.White
            )
        }


        // Vinyl lights effect
//        Image(
//            modifier = Modifier.fillMaxSize(),
//            painter = painterResource(id = R.drawable.vinyl_light),
//            contentDescription = "",
//        )
//
//        // Vinyl 'album' cover
//        // For using with Coil or Glide, wrap into surface with shape
//        Image(
//            modifier = Modifier
//                .fillMaxSize(0.3f)
//                .align(Alignment.Center)
//                .rotate(rotationDegrees)
//                .aspectRatio(1.0f)
//                .clip(CircleShape),
//            painter = painterResource(R.drawable.album_cover),
//            contentDescription = stringResource(id = R.string.album_cover)
//        )
    }
}

