package org.example

class ParkingLot(motorCycleCount: Int, carCount: Int, busCount: Int) {

    val slots = mutableMapOf<VehicleType, MutableList<Slot>>(
        VehicleType.MOTORCYCLE to mutableListOf(),
        VehicleType.CAR to mutableListOf(),
        VehicleType.BUS to mutableListOf()
    )

    init {
        for(i in 1..motorCycleCount) slots[VehicleType.MOTORCYCLE]?.addLast(Slot(i, VehicleType.MOTORCYCLE))
        for(i in 1..carCount) slots[VehicleType.CAR]?.addLast(Slot(i, VehicleType.CAR))
        for(i in 1..busCount) slots[VehicleType.BUS]?.addLast(Slot(i, VehicleType.BUS))
    }


    fun findEmptySlotFor(vehicle: Vehicle) : Slot {
        return Slot(1, vehicle.vehicleType)
    }

}
