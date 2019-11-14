package devit951.github.magictip.tip

import android.view.View
import androidx.core.view.children
import devit951.github.magictip.MagicTip
import devit951.github.magictip.MagicTipView

class OneMagicTip(anchorView: View, private val magicTip: MagicTip): MagicTip(anchorView) {

    override fun show() {
        if (!decorView.children.any { view -> view is MagicTipView }){
            magicTip.show()
        } else {
            val magicTipViewInDecorView =  (decorView.children.find { view -> view is MagicTipView } as? MagicTipView)
            magicTipViewInDecorView?.clickDelegate?.onClick(magicTipViewInDecorView, decorView)
        }
    }
}