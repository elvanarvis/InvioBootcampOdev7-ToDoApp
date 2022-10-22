package com.bootcamp.inviobootcampodev7_todoapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.changePage(v: View, id: Int) {
    findNavController(v).navigate(id)
}

fun Navigation.changePage(v: View, id: NavDirections) {
    findNavController(v).navigate(id)
}


