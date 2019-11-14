package devit951.github.magictipexample

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import devit951.github.magictip.MagicTip
import devit951.github.magictip.animationdelegate.CombinedMagicTipAnimation
import devit951.github.magictip.animationdelegate.OvershootMagicTipAnimation
import devit951.github.magictip.animationdelegate.ScaledTranslateMagicTipAnimation
import devit951.github.magictip.tip.AutoCloseMagicTip
import devit951.github.magictip.tip.OneMagicTip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_magictip.setOnClickListener { anchorView ->
            showMagicTip {
                MagicTip(anchorView)
                    .settings {
                        text = "Lorem Posen"
                        bgColor = Color.RED
                    }
            }
        }
        tv_auto_close_magictip.setOnClickListener {
            showMagicTip {
                AutoCloseMagicTip(it)
                    .settings {
                        text = "Lorem Posen"
                        bgColor = Color.GREEN
                    }
            }
        }
        iv_animated_magictip.setOnClickListener {
            showMagicTip {
                OneMagicTip(it, MagicTip(it)
                    .settings {
                        startAnimationDelegate =
                            CombinedMagicTipAnimation(ScaledTranslateMagicTipAnimation())
                        exitAnimationDelegate = ScaledTranslateMagicTipAnimation.Reversed()
                        text = "Lorem Posen"
                        bgColor = Color.BLUE
                    })
            }
        }
        tv_overshoot_magictip.setOnClickListener {
            showMagicTip {
                MagicTip(it)
                    .settings {
                        startAnimationDelegate = OvershootMagicTipAnimation()
                        exitAnimationDelegate = OvershootMagicTipAnimation.Reversed()
                        text = "Lorem Posen"
                        bgColor = Color.BLACK
                    }
            }
        }
    }

    private fun showMagicTip(magicTip: () -> MagicTip) {
        magicTip.invoke().show()
    }
}
