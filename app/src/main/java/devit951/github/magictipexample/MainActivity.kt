package devit951.github.magictipexample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import devit951.github.magictip.MagicTip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test.setOnClickListener { anchorView ->
            MagicTip(anchorView)
                .settings {
                    text = "Lorem Posen"
                    bgColor = Color.CYAN
                }
                .show()
        }
        imageView.setOnClickListener {
            MagicTip(it)
                .settings {
                    text = "Lorem Posen"
                    bgColor = Color.BLUE
                }
                .show()
        }
    }
}
