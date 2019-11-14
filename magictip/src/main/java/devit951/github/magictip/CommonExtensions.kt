package devit951.github.magictip

import android.app.Activity
import android.content.ContextWrapper
import android.content.res.Resources
import android.graphics.Color
import android.view.View
import kotlin.math.min
import kotlin.math.roundToInt


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

fun manipulateColor(color: Int, factor: Float) = Color.argb(
    Color.alpha(color),
    min((Color.red(color) * factor).roundToInt(), 255),
    min((Color.green(color) * factor).roundToInt(), 255),
    min((Color.blue(color) * factor).roundToInt(), 255)
)