import org.example.ParkingLot
import org.example.Vehicle
import org.example.VehicleType
import org.junit.jupiter.api.Test
import org.opentest4j.ValueWrapper
import kotlin.test.assertEquals

class ParkingLotTest {

    @Test
    fun `Parking lot creates 1 Motorcycle, 1 Car and 1 Bus by default`(){
        val parkingLot = ParkingLot(1, 1, 1)

        assertEquals(1, parkingLot.slots[VehicleType.MOTORCYCLE]?.size)
        assertEquals(1, parkingLot.slots[VehicleType.CAR]?.size)
        assertEquals(1, parkingLot.slots[VehicleType.BUS]?.size)


    }
    @Test
    fun `Parking lot is able to give a empty slot for a vehicle`(){

        val parkingLot = ParkingLot(1, 1, 1)

        val slot = parkingLot.findEmptySlotFor(VehicleType.MOTORCYCLE)

        assertEquals(VehicleType.MOTORCYCLE, slot?.vehicleType)
    }
    @Test
    fun `vehicle is able to be parked and a slot is assigned to it`(){
        val vehicle = Vehicle(VehicleType.MOTORCYCLE)

        val parkingLot = ParkingLot(1, 1, 1)

        val parkingTicket = parkingLot.park(vehicle)

        assertEquals(1, parkingTicket.spotId)

    }
}