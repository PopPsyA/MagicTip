package devit951.github.magictip.animationdelegate

import devit951.github.magictip.MagicTipAnimationDelegate
import devit951.github.magictip.MagicTipView

class CombinedMagicTipAnimation(private vararg val animations: MagicTipAnimationDelegate): MagicTipAnimationDelegate {
    override fun animate(magicTipView: MagicTipView) {
        animations.forEach { it.animate(magicTipView) }
    }
}