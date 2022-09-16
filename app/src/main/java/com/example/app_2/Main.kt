package com.example.app_2

import android.os.Build
import android.telecom.Call
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)

fun main() {

    //Agregamos los datos personales del empleado

    val staff = Employee(
        id = 9,
        fullName = "Carmen Lopez Hernadez",
        academicLevel = AcademicLevel.MASTER,
        dateOfAdmission = LocalDate.parse("2014-10-11"),
        curp = "CARM100199MOCDHM00",
        budgetKey = "PEBL99001"
    )

    // Agregamos el periodo

    val period =com.example.app_2.Period(
        initialDate = LocalDate.parse("2022-01-01"),
        finalDate = LocalDate.parse("2024-01-01"),
        description = "PERIODO"
    )

    //Asignmos un horario

    var listDetails = arrayListOf<Schedule.Detail>(
        Schedule.Detail(
            DayOfWeek.MONDAY,
            LocalTime.parse("08:00"),
            LocalTime.parse("15:00")
        ),
        Schedule.Detail(
            DayOfWeek.FRIDAY,
            LocalTime.parse("09:00"),
            LocalTime.parse("14:00")
        ))
    val schedule =Schedule.Builder(employee = staff, period= period)
        .addOne(Schedule.Detail(dayOfWeek =DayOfWeek.MONDAY,
            checkIn= LocalTime.parse("08:00"),
            checkOut= LocalTime.parse("14:00"))).build()


    val listOfCheckInOut = listOf<CheckInOut>(
        CheckInOut(
            LocalDate.parse("2022-09-12"),
            staff,
            LocalTime.parse("07:00"),
            LocalTime.parse("17:00")
        ))

    //Agregamos inicidentes que podrian ocurrir para contabilizar las faltas

    val incident = Incident(employee = staff, currentSchedule = schedule,
        checksInOut = listOfCheckInOut, permissions = listOf(),
        initialDate =LocalDate.parse("2020-10-10"),
        finalDate = LocalDate.parse("2020-10-20"))

    println("Ientificador: ${staff.id}" + '\n' +
            "Nombre del empleado: ${staff.fullName}" + '\n' +
            "Grado acdemico: ${staff.academicLevel}" + '\n' +
            "Genero: ${staff.getGenre()}" + '\n' +
            "Total de faltas: ${incident.getAbsences()}")

}


