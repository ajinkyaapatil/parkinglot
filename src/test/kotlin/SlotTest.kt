import org.example.Slot
import org.example.VehicleType
import kotlin.test.Test
import kotlin.test.assertEquals

class SlotTest {
    @Test
    fun `Slot is initially free to park vehicle`(){
        val slot = Slot(1, VehicleType.CAR)
        assertEquals(true, slot.availability)
    }
    @Test
    fun `when vehicle is park on a slot its availability is made unavailable`(){
        val slot = Slot(1, VehicleType.MOTORCYCLE)
        slot.occupy()
        assertEquals(false, slot.availability)
    }
    @Test
    fun `when vehicle is unparked on slot it is made available`(){
        val slot = Slot(1, VehicleType.MOTORCYCLE)
        slot.occupy()
        slot.free()
        assertEquals(true, slot.availability)
    }
    @Test
    fun `parking slot created has an ID`() {
        val slot = Slot(1, VehicleType.MOTORCYCLE)
        assertEquals(1, slot.id)
    }
}