package org.example

import java.math.BigDecimal
import java.util.*
import java.util.concurrent.TimeUnit

interface FeeModel {
    fun calculateFee(entryTime: Date, exitTime: Date, vehicleType: VehicleType) : BigDecimal

    fun findTimeDifference(entryTime : Date, exitTime : Date): Long {
        val diffInMillisecond: Long = exitTime.time - entryTime.time
        val diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMillisecond)
        return diffInMin
    }
}

class StadiumFeeModel : FeeModel{

    private val motorCycleIntervals = mutableListOf(
        Interval(0, 4, 30),
        Interval(4, 12, 60),
        Interval(12, Int.MAX_VALUE, 100)
    )

    private val carIntervals = mutableListOf(
        Interval(0, 4, 60),
        Interval(4, 12, 120),
        Interval(12, Int.MAX_VALUE, 200)
    )

    private val feeStructure = mutableMapOf(
        VehicleType.MOTORCYCLE to motorCycleIntervals,
        VehicleType.CAR to carIntervals
    )

    private fun findFeesIntervalAsPerBatch(hours: Long, vehicleType: VehicleType): Int {
        for(interval in feeStructure[vehicleType]!!){
            if(hours < interval.endHours) return interval.fee
        }
        return 0
    }

    override fun calculateFee(entryTime: Date, exitTime: Date, vehicleType: VehicleType): BigDecimal {
        val minutes = findTimeDifference(entryTime, exitTime)
        val hours = minutes / 60
        val remainMinutes = minutes - (hours * 60)
        return BigDecimal(hours * findFeesIntervalAsPerBatch(hours, vehicleType))
    }

}
//
//class AirportFeeModel : FeeModel{
//    override fun calculateFee(): Int {
//        TODO("Not yet implemented")
//    }
//
//}