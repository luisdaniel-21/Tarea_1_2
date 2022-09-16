package com.example.app_2

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

@Test
fun Seniority_isCorrect() {
    val employee = Employee(id = 1,
        fullName = "Rodolfo Ibarra Orozco",
        curp = "IORO651220HOCRMN09",
        dateOfAdmission = LocalDate.parse("2000-09-08"),
        budgetKey = "ABCDE12345",
        academicLevel = AcademicLevel.DOCTORAL
    )
    assertEquals(22, employee.getSeniority())
}


