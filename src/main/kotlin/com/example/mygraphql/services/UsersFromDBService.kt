package com.example.mygraphql.services

import com.example.mygraphql.queries.User
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class UsersFromDBService {

    suspend fun getUsers(): List<User> {
        delay(3000)
        println("Returning list of users from DB in Thread : " + Thread.currentThread().name)
        return listOf(
                User("ronaldo", "Porto")
        )
    }
}