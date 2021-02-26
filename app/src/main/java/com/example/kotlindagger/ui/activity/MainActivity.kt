package com.example.kotlindagger.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindagger.R
import com.example.kotlindagger.databinding.ActivityMainBinding
import com.example.kotlindagger.mvp.presenter.Presenter
import com.example.kotlindagger.mvp.view.View

class MainActivity : AppCompatActivity(), View {

    private lateinit var viewBinding: ActivityMainBinding

    val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val listener1 = android.view.View.OnClickListener {
            presenter.counterClick(0)
        }
        val listener2 = android.view.View.OnClickListener {
            presenter.counterClick(1)
        }
        val listener3 = android.view.View.OnClickListener {
            presenter.counterClick(2)
        }

        viewBinding.btnCounter1.setOnClickListener(listener1)
        viewBinding.btnCounter2.setOnClickListener(listener2)
        viewBinding.btnCounter3.setOnClickListener(listener3)
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> viewBinding.btnCounter1.text = text
            1 -> viewBinding.btnCounter2.text = text
            2 -> viewBinding.btnCounter3.text = text
        }
    }
}
