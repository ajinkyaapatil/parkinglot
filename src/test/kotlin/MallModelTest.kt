import org.example.MallFeeModel
import org.example.ParkingLot
import org.example.Vehicle
import org.example.VehicleType
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class MallModelTest {
    @Test
    fun `Motorcycle parked for 3 hours and 30 mins, Fees is 40`(){
        val mallFeeModel = MallFeeModel()

        val entryTime = Date()

        val fee = mallFeeModel.calculateFee(entryTime, Date(entryTime.time + 3 * 3600000 + 30 * 60000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(40), fee)

    }

    @Test
    fun `Car parked for 6 hours and 1 min, Fees is 140`(){
        val mallFeeModel = MallFeeModel()

        val entryTime = Date()

        val fee = mallFeeModel.calculateFee(entryTime, Date(entryTime.time + 6 * 3600000 + 1 * 60000), VehicleType.CAR)

        assertEquals(BigDecimal(140), fee)
    }

    @Test
    fun `Truck parked for 1 hour and 59 mins, Fees is 100`(){
        val mallFeeModel = MallFeeModel()

        val entryTime = Date()

        val fee = mallFeeModel.calculateFee(entryTime, Date(entryTime.time + 1 * 3600000 + 59 * 60000), VehicleType.BUS)

        assertEquals(BigDecimal(100), fee)
    }
}