package devit951.github.magictip

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import devit951.github.magictip.onclickdelegate.AnimatedClickDelegate
import devit951.github.magictip.onclickdelegate.ImmediatlyRemoveViewClickDelegate

class MagicTipView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr) {

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val trianglePath = Path()

    private var magicTipPadding = dp2Px(5)
    private var widthOfTriangle = dp2Px(14)
    private var heightOfTriangle = dp2Px(12)


    internal var clickDelegate: MagicTipClickDelegate = ImmediatlyRemoveViewClickDelegate()

    var bgColor = Color.RED
        set(value) {
            field = value
            bgPaint.color = value
            bgPaint.setShadowLayer(4f, 0.0f, 2.5f, manipulateColor(field, 0.8f))
        }

    var startAnimationDelegate: MagicTipAnimationDelegate? = null
    var exitAnimationDelegate: EndableMagicTipAnimationDelegate? = null
        set(value) {
            field = value
            clickDelegate = AnimatedClickDelegate()
        }

    init {
        setPadding(magicTipPadding, magicTipPadding, magicTipPadding, magicTipPadding + heightOfTriangle)
        setTextColor(Color.WHITE)
        bgPaint.color = bgColor
        layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            val margin = dp2Px(8)
            setMargins(margin, margin, margin, margin)
        }
        ViewCompat.setTranslationZ(this, Integer.MAX_VALUE.toFloat())
        setLayerType(View.LAYER_TYPE_SOFTWARE, bgPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        sizeSetUp(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat() - heightOfTriangle), 20f, 20f, bgPaint)
        canvas.drawPath(trianglePath, bgPaint)
        super.onDraw(canvas)
    }


    internal fun startEnterAnimation(){
        startAnimationDelegate?.animate(this)
    }

    internal fun startExitAnimation(onAnimationEnd: () -> Unit){
        exitAnimationDelegate?.animate(this, onAnimationEnd)
    }

    private fun sizeSetUp(w: Int, h: Int){
        val halfWidth = w / 2f
        val halfTriangleWidth = widthOfTriangle / 2f
        val y = h.toFloat() - heightOfTriangle
        trianglePath.moveTo(halfWidth - halfTriangleWidth, y)
        trianglePath.lineTo(halfWidth, h.toFloat() - 5)
        trianglePath.lineTo(halfWidth + halfTriangleWidth, y)
    }
}