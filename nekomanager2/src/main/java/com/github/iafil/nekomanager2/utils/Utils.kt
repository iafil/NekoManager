package com.github.iafil.nekomanager2.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun Context.getSession(prefName: String) = SessionManager(this, prefName)

fun FragmentActivity.setFragment(container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commit()
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <VDB: ViewDataBinding> Activity.getBinding(layout: Int): VDB =
    DataBindingUtil.setContentView(this, layout)

fun <VDB: ViewDataBinding> getBinding(
    layout: Int,
    inflater: LayoutInflater,
    parent: ViewGroup?
): VDB = DataBindingUtil.inflate(inflater, layout, parent, false)

fun <VDB: ViewDataBinding> getBinding(
    layout: Int,
    parent: ViewGroup?
): VDB = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), layout, parent, false)

fun <VM: ViewModel> FragmentActivity.obtainViewModel(clazz: Class<VM>) =
    ViewModelProviders.of(this).get(clazz)

fun <VM: ViewModel> Fragment.obtainViewModel(clazz: Class<VM>) =
    ViewModelProviders.of(this).get(clazz)

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}