package com.vitorhr.locator.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vitorhr.locator.usecase.FirebaseAnalyticsUseCase

class HomeViewModel(
    private val firebaseAnalyticsUseCase: FirebaseAnalyticsUseCase,
    private val context: Context,
) : ViewModel() {

    fun logRenderHomeScreenSuccess() {
        firebaseAnalyticsUseCase.logRenderHomeScreenSuccess()
    }

    fun setCurrentPosition(googleMap: GoogleMap) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        LocationServices.getFusedLocationProviderClient(context).lastLocation.addOnCompleteListener { task ->
            Log.d("TAG", "latitude: ${task.result.latitude}")
            val myLocation =
                LatLng(task.result.latitude, task.result.longitude)

            googleMap.addMarker(MarkerOptions().position(myLocation).title("My Marker"))
            Log.d("TAG", "setou o pin")
        }
    }
}