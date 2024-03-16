import org.example.AirportFeeModel
import org.example.MallFeeModel
import org.example.VehicleType
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class AirportModelTest {
    @Test
    fun `Motorcycle parked for 55 mins, Fees is 0`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 55 * 60000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(0), fee)
    }

    @Test
    fun `Motorcycle parked for 14 hours and 59 mins, Fees is 60`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 14 * 3600000 + 59 * 60000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(60), fee)
    }

    @Test
    fun `Motorcycle parked for 1 day and 12 hours, Fees is 160`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 36 * 3600000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(160), fee)
    }

    @Test
    fun `Car parked for 50 mins, Fees is 60`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 50 * 60000), VehicleType.CAR)

        assertEquals(BigDecimal(60), fee)
    }

    @Test
    fun `SUV parked for 23 hours and 59 mins, Fees is 80`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 23 * 3600000 + 59 * 60000), VehicleType.CAR)

        assertEquals(BigDecimal(80), fee)
    }

    @Test
    fun `Car parked for 3 days and 1 hour, Fees is 400`(){
        val airportFeeModel = AirportFeeModel()

        val entryTime = Date()

        val fee = airportFeeModel.calculateFee(entryTime, Date(entryTime.time + 73 * 3600000), VehicleType.CAR)

        assertEquals(BigDecimal(400), fee)
    }
}