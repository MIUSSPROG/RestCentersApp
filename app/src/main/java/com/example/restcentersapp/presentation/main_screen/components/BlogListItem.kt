package com.example.restcentersapp.presentation.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.util.robotoFamily

@Composable
fun BlogListItem(
    blogItem: BlogItem,
    modifier: Modifier,
    onItemClick: (BlogItem) -> Unit
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(5.dp).clickable { onItemClick(blogItem) }
    ) {
        Row(
            modifier = modifier.padding(5.dp)
        ) {
            ImageCard(
                url = blogItem.image.sm,
                modifier = Modifier
                    .size(width = 80.dp, height = 100.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.height(100.dp)) {
                Text(
                    text = blogItem.title,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )
                Text(
                    text = blogItem.subtitle,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )
            }
        }
    }

}

//val constraints = ConstraintSet {
//    val title = createRefFor("title")
//    val subtitle = createRefFor("subtitle")
//    val image = createRefFor("image")
//
//    constrain(image){
//        top.linkTo(parent.top)
//        start.linkTo(parent.start)
//        bottom.linkTo(parent.bottom)
//        height = Dimension.value(100.dp)
//        width = Dimension.value(80.dp)
//    }
//    constrain(title){
//        top.linkTo(image.top)
//        start.linkTo(image.end)
//        end.linkTo(parent.end)
//        width = Dimension.fillToConstraints
//    }
//    constrain(subtitle){
//        top.linkTo(title.bottom)
//        bottom.linkTo(image.bottom)
//        start.linkTo(title.start)
//        end.linkTo(title.end)
//        width = Dimension.fillToConstraints
//    }
//}
//
//ConstraintLayout(constraints, modifier = modifier) {
//    ImageCard(
//        url = blogItem.image.sm,
//        modifier = Modifier.layoutId("image"))
//    Text(
//        text = blogItem.title,
//        style = MaterialTheme.typography.body1,
//        textAlign = TextAlign.Start,
//        maxLines = 1,
//        overflow = TextOverflow.Ellipsis,
//        fontFamily = robotoFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 18.sp,
//        modifier = Modifier.layoutId("title")
//    )
//    Text(
//        text = blogItem.subtitle,
//        style = MaterialTheme.typography.body2,
//        textAlign = TextAlign.Start,
//        overflow = TextOverflow.Ellipsis,
//        fontFamily = robotoFamily,
//        fontWeight = FontWeight.Light,
//        fontSize = 16.sp,
//        modifier = Modifier.layoutId("subtitle")
//    )
//}