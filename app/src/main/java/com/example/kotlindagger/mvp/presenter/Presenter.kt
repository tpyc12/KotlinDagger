package com.example.kotlindagger.mvp.presenter

import com.example.kotlindagger.mvp.model.CountersModel
import com.example.kotlindagger.mvp.view.View

class Presenter(val view: View) {
    val model = CountersModel()

    fun counterClick(id: Int){
        val nextValue = model.next(id)
        view.setButtonText(id, nextValue.toString())
    }
}