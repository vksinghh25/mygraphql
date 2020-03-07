package com.example.mygraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class PeopleQuery : Query {

    fun people(nameStartsWith: String?): List<People> = listOf(
            Attendee("Jane", TicketType.CONFERENCE),
            Speaker("Vk Singh", listOf("Scala 101", "Kotlin 101")),
            Speaker("Varun Kapoor", listOf("Management 101"))
    ).filter {
        it.name.startsWith(nameStartsWith ?: "")
    }
}

interface People {
    val name: String
}

data class Attendee(
        override val name: String,
        val ticket: TicketType
) : People

enum class TicketType {
    CONFERENCE, WORKSHOP, FULL
}

data class Speaker(
        override val name: String,
        val talks: List<String>
) : People
