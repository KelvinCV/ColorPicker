package br.unifor.cct.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import colorpicker.R

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mViewColor: View

    private lateinit var mSeekBarRedValue: SeekBar
    private lateinit var mSeekBarGreenValue: SeekBar
    private lateinit var mSeekBarBlueValue: SeekBar

    private lateinit var mTextViewRvalue: TextView
    private lateinit var mTextViewGvalue: TextView
    private lateinit var mTextViewBvalue: TextView

    private lateinit var mTextViewHexValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewColor = findViewById(R.id.main_view_color)

        mSeekBarRedValue = findViewById(R.id.main_seekBarRed_value)
        mSeekBarGreenValue = findViewById(R.id.main_seekBarGreen_value)
        mSeekBarBlueValue = findViewById(R.id.main_seekBarBlue_value)

        mTextViewRvalue = findViewById(R.id.main_textViewR_value)
        mTextViewGvalue = findViewById(R.id.main_textViewG_value)
        mTextViewBvalue = findViewById(R.id.main_textViewB_value)

        mTextViewHexValue = findViewById(R.id.main_textViewHex_value)

        mSeekBarRedValue.setOnSeekBarChangeListener(this)
        mSeekBarGreenValue.setOnSeekBarChangeListener(this)
        mSeekBarBlueValue.setOnSeekBarChangeListener(this)

    }
    override fun onStart(){
        super.onStart()
        showRGBvalues()
        showHexValues()
    }

    fun showRGBvalues() {
        mTextViewRvalue.text = mSeekBarRedValue.progress.toString()
        mTextViewGvalue.text = mSeekBarGreenValue.progress.toString()
        mTextViewBvalue.text = mSeekBarBlueValue.progress.toString()

        Log.i("App", "R: ${mSeekBarRedValue.progress}, G: ${mSeekBarGreenValue.progress}, B: ${mSeekBarBlueValue.progress}")
    }

    @SuppressLint("SetTextI18n")
    fun showHexValues(){
        mTextViewHexValue.text = "#" +
                String.format("%02X", mSeekBarRedValue.progress) +
                String.format("%02X", mSeekBarGreenValue.progress) +
                String.format("%02X", mSeekBarBlueValue.progress)

        Log.i("App", "Hex: ${mTextViewHexValue.text}")

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        mViewColor.setBackgroundColor(Color.rgb(mSeekBarRedValue.progress, mSeekBarGreenValue.progress, mSeekBarBlueValue.progress))
        showRGBvalues()
        showHexValues()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "User is touching the seekBar!")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "User is NOT touching the seekBar anymore!")
    }

}