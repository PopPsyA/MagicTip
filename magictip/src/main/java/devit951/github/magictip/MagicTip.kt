package devit951.github.magictip

import android.view.View
import android.view.ViewGroup
import java.lang.ref.WeakReference

class MagicTip(private val anchorView: View) {

    private val weakAnchorView = WeakReference<View>(anchorView)
    private val decorView: ViewGroup
    private val magicTipView: MagicTipView
    private var onMagicTipView: (MagicTipView.() -> Unit)? = null

    init {
        val activity = weakAnchorView.get()!!.activity()
        decorView = activity.window.decorView as ViewGroup
        magicTipView = MagicTipView(activity)
    }

    fun settings(magicTipView: MagicTipView.() -> Unit): MagicTip{
        onMagicTipView = magicTipView
        return this
    }

    fun show(){
        decorView.addView(magicTipView.apply {
            visibility = View.INVISIBLE
            onMagicTipView?.invoke(this)
            anchorView.post{
                val location = intArrayOf(0, 0)
                anchorView.getLocationOnScreen(location)
                post {
                    x = location[0].toFloat() + ((anchorView.width - width) / 2f)
                    y = location[1].toFloat() - height - dp2Px(4)
                    visibility = View.VISIBLE
                }
            }
            setOnClickListener {
                decorView.removeView(this)
            }
        })
    }
}