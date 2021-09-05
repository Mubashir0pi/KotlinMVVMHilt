package com.assignment.movieapplication.utils

import android.content.Context
import android.content.Intent
import android.net.Uri


object Utils {


    fun openUrl(reviewUrl: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(reviewUrl))
            .addCategory(Intent.CATEGORY_BROWSABLE)
        context.startActivity(intent)
    }


}