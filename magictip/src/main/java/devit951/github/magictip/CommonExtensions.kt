package devit951.github.magictip

import android.content.Context
import android.content.res.Resources
import android.content.ContextWrapper
import android.app.Activity
import android.view.View


fun dp2Px(dp: Int): Int = (Resources.getSystem().displayMetrics.density * dp).toInt()

fun View.activity(): Activity {
    var context = context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    error("Activity could not find")
}