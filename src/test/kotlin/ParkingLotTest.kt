import org.example.ParkingLot
import org.example.Vehicle
import org.example.VehicleType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParkingLotTest {
    @Test
    fun `parking lot is able to give a empty slot for a vehicle`(){
        val vehicle = Vehicle(VehicleType.MOTORCYCLE)

        val parkingLot = ParkingLot()

        val slot = parkingLot.findEmptySlotFor(vehicle)

        assertEquals(VehicleType.MOTORCYCLE, slot.vehicleType)
    }
}