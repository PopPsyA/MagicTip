package devit951.github.magictip

import android.view.ViewGroup

interface MagicTipClickDelegate {
    fun onClick(magicTipView: MagicTipView, decorView: ViewGroup)
}