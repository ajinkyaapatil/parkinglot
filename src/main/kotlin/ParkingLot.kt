package org.example

class ParkingLot {
    fun findEmptySlotFor(vehicle: Vehicle) : Slot {
        return Slot(1, vehicle.vehicleType)
    }

}
