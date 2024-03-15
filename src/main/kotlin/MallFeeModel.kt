package org.example

import java.math.BigDecimal
import java.util.*

class MallFeeModel : FeeModel {
    private val feeStructure = mutableMapOf(
        VehicleType.MOTORCYCLE to 10,
        VehicleType.CAR to 20,
        VehicleType.BUS to 50
    )

    override fun calculateFee(entryTime: Date, exitTime: Date, vehicleType: VehicleType): BigDecimal {
        val minutes = findTimeDifference(entryTime, exitTime)
        var hours = minutes / 60
        val remainMinutes = minutes - (hours * 60)
        if (remainMinutes > 0) hours++;
        return BigDecimal(hours * feeStructure[vehicleType]!!)
    }
}