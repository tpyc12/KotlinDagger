package com.example.kotlindagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.kotlindagger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.btnCounter1.setOnClickListener {
            viewBinding.btnCounter1.text = (++counters[0]).toString()
        }

        viewBinding.btnCounter2.setOnClickListener {
            viewBinding.btnCounter2.text = (++counters[1]).toString()
        }

        viewBinding.btnCounter3.setOnClickListener {
            viewBinding.btnCounter3.text = (++counters[2]).toString()
        }

        initViews()
    }

    fun initViews() {
        viewBinding.btnCounter1.text = counters[0].toString()
        viewBinding.btnCounter2.text = counters[1].toString()
        viewBinding.btnCounter3.text = counters[2].toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray("counters")
        countersArray?.toList().let {
            counters.clear()
            it?.let { it1 -> counters.addAll(it1) }
        }
        initViews()
    }

}
