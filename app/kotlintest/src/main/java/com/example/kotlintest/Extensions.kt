package com.example.kotlintest

import com.example.kotlintest.model.Student
//función de extension
fun Student.getFullNameUppercase()= "$name $lastname".uppercase()
