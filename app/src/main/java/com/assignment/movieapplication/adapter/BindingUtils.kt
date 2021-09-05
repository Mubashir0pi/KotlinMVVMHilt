package  com.assignment.movieapplication.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.assignment.movieapplication.R
import com.bumptech.glide.Glide

@BindingAdapter("poster")
fun ImageView.setPoster(fullPosterPath: String?) {

    fullPosterPath?.let {
        Glide.with(this).load(it).error(R.drawable.no_image).into(this)
    }
}

@BindingAdapter("loadImage")
fun ImageView.setImage(image: String?) {

    image?.let {
        Glide.with(this).load(it).into(this)
    }
}

@BindingAdapter("itemImage")
fun ImageView.setItemImage(fullProfilePath: String?) {

    fullProfilePath?.let {
        Glide.with(this).load(it).error(R.drawable.no_image).into(this)
    }
}
