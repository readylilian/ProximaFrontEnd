package com.example.proxima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.GoogleMap.*
import com.google.android.gms.maps.model.*
import android.widget.TextView
import android.util.Log

inline fun <reified T> T.logi(message: String) = Log.i(T::class.java.simpleName, message)
class EventsMap : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var tapTextView: TextView
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_events_map)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val view = mapFragment.view
        view?.isClickable = true
        tapTextView = findViewById(R.id.tap_text)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        // Add a marker in Sydney and move the camera
        val rit = LatLng(43.08527798116643, -77.67620189789763)
        //googleMap.addMarker(MarkerOptions().position(sydney).title("Magic"))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(18F))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(rit))
        map = googleMap
    }

}