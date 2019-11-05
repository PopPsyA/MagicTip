package devit951.github.magictip.onclickdelegate

import android.view.ViewGroup
import devit951.github.magictip.MagicTipClickDelegate
import devit951.github.magictip.MagicTipView

class ImmediatlyRemoveViewClickDelegate: MagicTipClickDelegate {
    override fun onClick(magicTipView: MagicTipView, decorView: ViewGroup) {
        decorView.removeView(magicTipView)
    }
}