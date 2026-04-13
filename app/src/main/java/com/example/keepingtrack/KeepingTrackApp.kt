package com.example.keepingtrack

import androidx.annotation.StringRes

enum class AppScreen(@StringRes val title:Int) {
    Login(R.string.login),
    Home(R.string.home),
    Add(R.string.add_counter)

}