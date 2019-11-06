package devit951.github.magictip

import android.view.View
import androidx.core.view.children

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