package com.example.mygraphql.queries

import com.example.mygraphql.services.UserFromCacheService
import com.example.mygraphql.services.UsersFromDBService
import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Component

@Component
class UsersQuery(val userFromCacheService: UserFromCacheService,
                 val usersFromDBService: UsersFromDBService) : Query {

    suspend fun users(): List<User> = coroutineScope {
        val cached = async { userFromCacheService.getUsers() }
        val db = async { usersFromDBService.getUsers() }

        listOf(cached.await(), db.await()).flatten()
    }
}

data class User(val name: String, val location: String)