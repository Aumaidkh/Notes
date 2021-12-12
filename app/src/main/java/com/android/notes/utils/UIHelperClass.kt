package com.android.notes.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.os.Build
import android.R
import android.view.Window

import androidx.core.content.ContextCompat







class UIHelperClass {

    companion object {

        fun setLightStatusBar(view: View, activity: Activity) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                var flags = view.systemUiVisibility
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                view.systemUiVisibility = flags
                activity.window.statusBarColor = Color.WHITE
            }
        }

        fun clearLightStatusBar(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val window: Window = activity.window
                window.setStatusBarColor(
                    ContextCompat
                        .getColor(activity, R.color.background_dark)
                )
            }
        }
    }



}