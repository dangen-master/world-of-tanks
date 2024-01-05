package com.example.tanks

import android.graphics.Path.Direction
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.tanks.MyDirection.UP
import com.example.tanks.MyDirection.DOWN
import com.example.tanks.MyDirection.LEFT
import com.example.tanks.MyDirection.RIGHT
import androidx.activity.ComponentActivity
import com.example.tanks.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KEYCODE_DPAD_UP -> move(UP)
            KEYCODE_DPAD_DOWN -> move(DOWN)
            KEYCODE_DPAD_LEFT -> move(LEFT)
            KEYCODE_DPAD_RIGHT -> move(RIGHT)
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: MyDirection){
        val layoutParams = binding.MyTank.layoutParams as LinearLayout.LayoutParams
            when(direction) {
            UP -> {
                binding.MyTank.rotation = 0f
                if(layoutParams.topMargin > 0) {
                    layoutParams.topMargin += -50
                }
            }
            DOWN -> {
                binding.MyTank.rotation = 180f
                if(layoutParams.topMargin + binding.MyTank.height < (50 * 41)) {

                    (binding.MyTank.layoutParams as LinearLayout.LayoutParams).topMargin += 50
                }
            }
            LEFT -> {
                binding.MyTank.rotation = 270f
                if(layoutParams.leftMargin > 0){

                    layoutParams.leftMargin -= 50
                }
            }
            RIGHT -> {
                binding.MyTank.rotation = 90f
                if(layoutParams.leftMargin + binding.MyTank.width < (50 * 21))
                {

                    layoutParams.leftMargin += 50
                }
            }
        }
        binding.actionContainer.removeView(binding.MyTank)
        binding.actionContainer.addView(binding.MyTank)
    }
}

