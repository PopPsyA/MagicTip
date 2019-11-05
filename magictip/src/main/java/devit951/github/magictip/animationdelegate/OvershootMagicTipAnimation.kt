package devit951.github.magictip.animationdelegate

import android.view.animation.OvershootInterpolator
import devit951.github.magictip.MagicTipAnimationDelegate
import devit951.github.magictip.MagicTipView

class OvershootMagicTipAnimation : MagicTipAnimationDelegate {
    override fun animate(magicTipView: MagicTipView) {
        magicTipView.scaleX = 0f
        magicTipView.scaleY = 0f
        magicTipView.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setInterpolator(OvershootInterpolator(3.5f))

    }
}