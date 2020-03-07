package com.example.mygraphql.services

import com.example.mygraphql.queries.User
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class UserFromCacheService {

    suspend fun getUsers(): List<User> {
        delay(100)
        println("Returning list of users from Cache in Thread : " + Thread.currentThread().name)
        return listOf(
                User("vksinghh", "Gurgaon"),
                User("johndoe", "NYC")
        )
    }
}