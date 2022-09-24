package com.example.restcentersapp.util
import android.graphics.drawable.Drawable
import androidx.compose.runtime.*
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.core.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception


@Composable
fun loadPicture(url: String, modifier: Modifier) {

    var image by remember{ mutableStateOf<ImageBitmap?>(null)}
    var drawable by remember { mutableStateOf<Drawable?>(null) }

    DisposableEffect(url) {

        val picasso = Picasso.get()
        val target = object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                drawable = placeHolderDrawable
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                image = bitmap?.asImageBitmap()
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                drawable = errorDrawable
            }
        }

        picasso.load(url).into(target)
//            .placeholder(R.drawable.image_empty_holder)
//            .error(R.drawable)

        onDispose {
            image = null
            drawable = null
            picasso.cancelRequest(target)
        }
    }

    if (image != null){
        Image(bitmap = image!!, contentDescription = "image", contentScale = ContentScale.Crop)
    }else if (drawable != null){
        Canvas(modifier = modifier){
            drawIntoCanvas { canvas ->
                drawable!!.draw(canvas.nativeCanvas)
            }
        }
    }
}

