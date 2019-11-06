package devit951.github.magictip.animationdelegate

import android.view.ViewPropertyAnimator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import devit951.github.magictip.EndableMagicTipAnimationDelegate
import devit951.github.magictip.MagicTipAnimationDelegate
import devit951.github.magictip.MagicTipView

class ScaledTranslateMagicTipAnimation(
    private val fromValue: Float = 0f,
    private val toValue: Float = 1f
) : MagicTipAnimationDelegate {

    override fun animate(magicTipView: MagicTipView) {
        magicTipView.y += magicTipView.height * 0.5f
        animated(magicTipView)
    }

    internal fun animated(magicTipView: MagicTipView): ViewPropertyAnimator {
        return magicTipView.run {
            scaleX = fromValue
            scaleY = fromValue
            animate()
                .scaleX(toValue)
                .scaleY(toValue)
                .y(magicTipView.y - magicTipView.height * 0.5f)
        }
    }

    class Reversed : EndableMagicTipAnimationDelegate {

        private val scaledTranslateMagicTipAnimation =
            ScaledTranslateMagicTipAnimation(fromValue = 1f, toValue = 0f)

        override fun animate(magicTipView: MagicTipView, onAnimationEnd: () -> Unit) {
            scaledTranslateMagicTipAnimation
                .animated(magicTipView)
                .y(magicTipView.y + magicTipView.height * 0.5f)
                .setInterpolator(FastOutSlowInInterpolator())
                .withEndAction(onAnimationEnd)
        }
    }
}