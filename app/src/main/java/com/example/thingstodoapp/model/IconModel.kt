package com.example.thingstodoapp.model


data class IconModel(
    val iconImg: Int,
    val iconTitle: String? = null,
    var isChecked: Boolean = false
) {
}