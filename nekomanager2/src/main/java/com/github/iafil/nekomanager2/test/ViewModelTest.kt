package com.github.iafil.nekomanager2.test

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.iafil.nekomanager2.utils.obtainViewModel

class ViewModelTest : Fragment() {

    fun test() {
        val vm = obtainViewModel(MainViewModel::class.java)
        vm.name.observe(this, Observer {

        })
    }
}