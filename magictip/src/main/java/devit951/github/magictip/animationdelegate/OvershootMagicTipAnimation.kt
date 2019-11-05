package devit951.github.magictip.animationdelegate

import android.view.ViewPropertyAnimator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import devit951.github.magictip.EndableMagicTipAnimationDelegate
import devit951.github.magictip.MagicTipAnimationDelegate
import devit951.github.magictip.MagicTipView

class OvershootMagicTipAnimation(
    private val fromValue: Float = 0f,
    private val toValue: Float = 1f
) : MagicTipAnimationDelegate {
    override fun animate(magicTipView: MagicTipView) {
        animated(magicTipView)
    }

    internal fun animated(magicTipView: MagicTipView): ViewPropertyAnimator {
        return magicTipView.run {
            scaleX = fromValue
            scaleY = fromValue
            animate()
                .scaleX(toValue)
                .scaleY(toValue)
                .setInterpolator(OvershootInterpolator(3.5f))
        }
    }

    class Reversed : EndableMagicTipAnimationDelegate {

        private val overshootMagicTipAnimation = OvershootMagicTipAnimation(fromValue = 1f, toValue = 0f)

        override fun animate(magicTipView: MagicTipView, onAnimationEnd: () -> Unit) {
            overshootMagicTipAnimation.animated(magicTipView)
                .setInterpolator(LinearInterpolator())
                .withEndAction {
                    onAnimationEnd.invoke()
                }
        }
    }
}