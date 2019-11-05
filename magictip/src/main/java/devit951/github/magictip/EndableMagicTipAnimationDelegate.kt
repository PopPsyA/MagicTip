package devit951.github.magictip

interface EndableMagicTipAnimationDelegate {
    fun animate(magicTipView: MagicTipView, onAnimationEnd: () -> Unit)
}