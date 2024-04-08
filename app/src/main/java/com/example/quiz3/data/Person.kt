package com.example.quiz3.data

import androidx.annotation.StringRes
import com.example.quiz3.R

data class Person(
    @StringRes val icon: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val city: Int
)

val persons = listOf(
    Person(R.string.person1_icon,R.string.person1_name, 18, R.string.person1_city),
    Person(R.string.person2_icon, R.string.person2_name, 21, R.string.person2_city),
    Person(R.string.person3_icon, R.string.person3_name, 19, R.string.person3_city),
    Person(R.string.person4_icon, R.string.person4_name, 25, R.string.person4_city),
    Person(R.string.person5_icon, R.string.person5_name, 27, R.string.person5_city),
    Person(R.string.person6_icon, R.string.person6_name, 21, R.string.person6_city),
    Person(R.string.person7_icon, R.string.person7_name, 19, R.string.person7_city),
    Person(R.string.person8_icon, R.string.person8_name, 25, R.string.person8_city)
)