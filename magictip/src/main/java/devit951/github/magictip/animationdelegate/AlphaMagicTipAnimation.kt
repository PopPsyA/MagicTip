package devit951.github.magictip.animationdelegate

import devit951.github.magictip.MagicTipAnimationDelegate
import devit951.github.magictip.MagicTipView

class AlphaMagicTipAnimation : MagicTipAnimationDelegate {
    override fun animate(magicTipView: MagicTipView) {
        magicTipView.alpha = 0f
        magicTipView.animate()
            .alpha(1f)
    }
}