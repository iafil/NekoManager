package com.github.iafil.nekomanager2

@Suppress("unused")
object PluginManager {

    val project = """
        maven { url 'https://jitpack.io' }
    """.trimIndent()

    val app = """
        apply plugin: 'kotlin-kapt'
        
        dataBinding {
            enabled true
        }
        
        implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
        implementation 'androidx.recyclerview:recyclerview:1.1.0'
        implementation 'com.squareup.retrofit2:retrofit:2.6.1'
        implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
    """.trimIndent()
}