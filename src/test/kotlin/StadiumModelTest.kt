import org.example.StadiumFeeModel
import org.example.VehicleType
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class StadiumModelTest {
    @Test
    fun `Motorcycle parked for 3 hours and 40 mins, Fees is 30`(){
        val stadiumFeeModel = StadiumFeeModel()

        val entryTime = Date()

        val fee = stadiumFeeModel.calculateFee(entryTime, Date(entryTime.time + 3 * 3600000 + 40 * 60000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(30), fee)
    }

    @Test
    fun `Motorcycle parked for 14 hours and 59 mins, Fees is 390`(){
        val stadiumFeeModel = StadiumFeeModel()

        val entryTime = Date()

        val fee = stadiumFeeModel.calculateFee(entryTime, Date(entryTime.time + 14 * 3600000 + 59 * 60000), VehicleType.MOTORCYCLE)

        assertEquals(BigDecimal(390), fee)
    }

    @Test
    fun  `Electric SUV parked for 11 hours and 30 mins, Fees is 180`(){
        val stadiumFeeModel = StadiumFeeModel()

        val entryTime = Date()

        val fee = stadiumFeeModel.calculateFee(entryTime, Date(entryTime.time + 11 * 3600000 + 30 * 60000), VehicleType.CAR)

        assertEquals(BigDecimal(180), fee)
    }

    @Test
    fun `SUV parked for 13 hours and 5 mins, Fees is 580`(){
        val stadiumFeeModel = StadiumFeeModel()

        val entryTime = Date()

        val fee = stadiumFeeModel.calculateFee(entryTime, Date(entryTime.time + 13 * 3600000 + 5 * 60000), VehicleType.CAR)

        assertEquals(BigDecimal(580), fee)
    }
}