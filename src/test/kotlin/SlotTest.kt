import org.example.Slot
import org.example.VehicleType
import kotlin.test.Test
import kotlin.test.assertEquals

class SlotTest {
    @Test
    fun `parking slot created has an ID`() {
        val slot = Slot(1, VehicleType.MOTORCYCLE)
        assertEquals(1, slot.id)
    }
}