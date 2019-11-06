package devit951.github.magictipexample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import devit951.github.magictip.AutoCloseMagicTip
import devit951.github.magictip.MagicTip
import devit951.github.magictip.animationdelegate.AlphaMagicTipAnimation
import devit951.github.magictip.animationdelegate.CombinedMagicTipAnimation
import devit951.github.magictip.animationdelegate.ScaledTranslateMagicTipAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            MagicTip(it)
                .settings {
                    startAnimationDelegate = CombinedMagicTipAnimation(ScaledTranslateMagicTipAnimation())
                    exitAnimationDelegate = ScaledTranslateMagicTipAnimation.Reversed()
                    text =  "Lorem Posen"
                    bgColor = Color.BLUE
                }
                .show()
        }
    }
}
