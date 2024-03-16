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


class AirportFeeModel : FeeModel{

    private val motorCycleIntervals = mutableListOf(
        Interval(0, 1, 0),
        Interval(1, 8, 40),
        Interval(8, 24, 60),
    )

    private val carIntervals = mutableListOf(
        Interval(0, 12, 60),
        Interval(12, 24, 80),
    )

    private val feeStructure = mutableMapOf(
        VehicleType.MOTORCYCLE to motorCycleIntervals,
        VehicleType.CAR to carIntervals
    )

    private val perDayFeeStructure = mutableMapOf(
        VehicleType.MOTORCYCLE to 80,
        VehicleType.CAR to 100
    )

    private fun findFeesIntervalAsPerBatch(hours: Long, vehicleType: VehicleType): BigDecimal {

        var days = hours / 24

        val remainHours = hours - (days * 24)

        if(remainHours > 0) days++

        if(hours > 24) return BigDecimal((days) * perDayFeeStructure[vehicleType]!!)

        for (interval in feeStructure[vehicleType]!!){
            if(hours < interval.endHours){
                return BigDecimal(interval.fee)
            }
        }

        return BigDecimal.ZERO

    }

    override fun calculateFee(entryTime: Date, exitTime: Date, vehicleType: VehicleType): BigDecimal {
        val minutes = findTimeDifference(entryTime, exitTime)
        val hours = minutes / 60
        return findFeesIntervalAsPerBatch(hours, vehicleType)
    }

}