package org.example

import java.math.BigDecimal
import java.util.*

class ParkingReceipt(
    val receiptNumber: String,
    val entryTime: Date,
    val exitTime: Date,
    val fees: BigDecimal
) {

}
