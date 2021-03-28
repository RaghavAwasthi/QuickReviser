package com.app.easyreviser.utils

import android.widget.EditText

object TextUtils {

    fun checkNotEmpty(view: EditText, len: Int = 0): Boolean {
        return view.text != null && view.text.toString().length > len
    }


    fun validateFields(vararg view: EditText): Boolean {
       view.forEach {
            if (!checkNotEmpty(it)) {
                it.error = "Field Cannot be Empty!!!"
                return false
            }
        }
        return true
    }


}