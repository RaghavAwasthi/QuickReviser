package com.app.easyreviser.utils

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.widget.ImageView

object AppUtils {
    fun ImageView.setImageDrawableWithAnimation(drawable: Drawable, duration: Int = 300) {
        val currentDrawable = getDrawable()
        if (currentDrawable == null) {
            setImageDrawable(drawable)
            return
        }

        val transitionDrawable = TransitionDrawable(
            arrayOf(
                currentDrawable,
                drawable
            )
        )
        setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(duration)
    }
}