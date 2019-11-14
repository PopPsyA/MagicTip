package devit951.github.magictipexample

import android.annotation.TargetApi
import android.graphics.Color
import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import devit951.github.magictip.tip.AutoCloseMagicTip
import devit951.github.magictip.MagicTip
import devit951.github.magictip.tip.OneMagicTip
import devit951.github.magictip.animationdelegate.CombinedMagicTipAnimation
import devit951.github.magictip.animationdelegate.ScaledTranslateMagicTipAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test.setOnClickListener { anchorView ->
            AutoCloseMagicTip(anchorView)
                .settings {
                    text = "Lorem Posen"
                    bgColor = Color.CYAN
                }
                .show()
        }
        imageView.setOnClickListener {
            OneMagicTip(it, MagicTip(it)
                .settings {
                    startAnimationDelegate =
                        CombinedMagicTipAnimation(ScaledTranslateMagicTipAnimation())
                    exitAnimationDelegate = ScaledTranslateMagicTipAnimation.Reversed()
                    text = "Lorem Posen"
                    bgColor = Color.BLUE

                })
                .show()
        }
    }
}
