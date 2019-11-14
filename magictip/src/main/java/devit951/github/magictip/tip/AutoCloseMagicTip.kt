package devit951.github.magictip.tip

import android.os.Handler
import android.view.View
import devit951.github.magictip.MagicTip

class AutoCloseMagicTip(anchorView: View, private val delay: Long = 1_000): MagicTip(anchorView){
    override fun show() {
        super.show()
        Handler().postDelayed({
            magicTipView.clickDelegate.onClick(magicTipView, decorView)
        }, delay)
    }
}