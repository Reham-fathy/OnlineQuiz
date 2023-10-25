package com.example.onlinequiz.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

    fun isNetworkAvailable(context: Context):Boolean{
        val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
        val network= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork?:return false
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        val activeNetwork =connectivityManager.getNetworkCapabilities(network)?:return false
        return when{
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)->true
            else->false

        }
    }
}