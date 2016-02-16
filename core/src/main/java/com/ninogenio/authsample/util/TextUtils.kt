package com.ninogenio.authsample.util

/**
 * Created by gentr on 11-Feb-16.
 */
object TextUtils {

    /**
     * Returns true if the string is null or 0-length.

     * @param str the string to be examined
     * *
     * @return true if str is null or zero length
     */
    fun isEmpty(str: CharSequence?): Boolean {
        if (str == null || str.length == 0)
            return true
        else
            return false
    }

}
