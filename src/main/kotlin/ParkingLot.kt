package org.example

import java.util.*

class ParkingLot(motorCycleCount: Int, carCount: Int, busCount: Int, val feeModel: FeeModel) {

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


    fun findEmptySlotFor(vehicleType: VehicleType) : Slot? {
        return slots[vehicleType]?.first { it.availability }
    }

    fun park(vehicle: Vehicle): ParkingTicket {
        val availSlot = findEmptySlotFor(vehicle.vehicleType)
        if (availSlot == null) throw Exception("No Empty Slot Found")
        else{
            availSlot.occupy()
            return ParkingTicket(1, availSlot.id, Date(), vehicle.vehicleType)
        }
    }

    fun unpark(parkingTicket: ParkingTicket): ParkingReceipt {
        val slot = slots[parkingTicket.vehicleType]?.find { it.id == parkingTicket.spotId }
        slot?.free()
        val fees = feeModel.calculateFee(parkingTicket.entryDate, Date(), parkingTicket.vehicleType)
        return ParkingReceipt("R-${parkingTicket.ticketNumber}", parkingTicket.entryDate, Date(), fees)
    }

}
