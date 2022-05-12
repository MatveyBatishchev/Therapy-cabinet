package ru.mospolytech.therapy_room

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["ru.mospolytech"])
class TherapyRoomApplication

fun main(args: Array<String>) {
    runApplication<TherapyRoomApplication>(*args)
}