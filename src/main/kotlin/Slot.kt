package org.example

class Slot(val id: Int, val vehicleType: VehicleType) {
    var availability = true

    fun occupy(){
        availability = false
    }

    fun free(){
        availability = true
    }
}
