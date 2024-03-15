import org.example.Slot
import kotlin.test.Test
import kotlin.test.assertEquals

class SlotTest {
    @Test
    fun `parking slot created has an ID`(){
        val slot = Slot(1)

        assertEquals(1, slot.id)
    }
}