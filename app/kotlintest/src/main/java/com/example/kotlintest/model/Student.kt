package com.example.kotlintest.model

data class Student(
    val id:Long,
    var name: String,
    var lastname: String
)
{
    fun getFullName()="$name $lastname"
}
