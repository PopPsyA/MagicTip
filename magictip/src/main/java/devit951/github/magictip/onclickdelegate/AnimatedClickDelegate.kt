package devit951.github.magictip.onclickdelegate

import android.view.ViewGroup
import devit951.github.magictip.MagicTipClickDelegate
import devit951.github.magictip.MagicTipView

class AnimatedClickDelegate: MagicTipClickDelegate {
    override fun onClick(magicTipView: MagicTipView, decorView: ViewGroup) {
        magicTipView.startExitAnimation {
            decorView.removeView(magicTipView)
        }
    }
}