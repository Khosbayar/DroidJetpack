package hs.khosbayar.droidjetpack

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import hs.khosbayar.droidjetpack.employee.Status

@BindingAdapter("imageLoading")
fun imageLoading(imageView: ImageView, status: Status?) {
    status?.let {
        when (it) {
            Status.LOADING -> {
                imageView.setImageResource(R.drawable.loading_animation)
                imageView.visibility = View.VISIBLE
            }
            Status.ERROR -> {
                imageView.setImageResource(R.drawable.ic_connection_error)
                imageView.visibility = View.VISIBLE
            }
            Status.DONE -> {
                imageView.visibility = View.GONE
            }
        }
    }
}