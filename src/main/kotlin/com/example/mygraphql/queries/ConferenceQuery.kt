package com.example.mygraphql.queries

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ConferenceQuery : Query {

    fun conference() = Conference(name = "Kotlin Conf", year = 2019)
}

data class Conference(
        @GraphQLDescription("Name of the conference")
        val name: String,

        @GraphQLDescription("Year it was run")
        val year: Int?
)