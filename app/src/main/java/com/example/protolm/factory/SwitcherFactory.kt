package com.example.protolm.factory

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.ViewSwitcher

class SwitcherFactory (val ctx: Context) : ViewSwitcher.ViewFactory{
    override fun makeView(): View {
        val textView = TextView(ctx)
        textView.gravity = Gravity.TOP or Gravity.LEFT
        textView.textSize = 16f
        textView.setTextColor(Color.BLACK)
        return textView
    }

}