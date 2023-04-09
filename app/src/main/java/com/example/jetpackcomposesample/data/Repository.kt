package com.example.jetpackcomposesample.data

class Repository {
    fun getEmployees(): List<Employee> {
        return listOf(
            Employee(1, "Manoj Bajpayee", 40),
            Employee(2, "Dev Anand", 23),
            Employee(3, "Nawazuddin Siddiqui", 60),
            Employee(4, "Anupam Kher", 22),
            Employee(5, "Saif Ali Khan", 30),
            Employee(6, "Aamir Khan", 30),
            Employee(7, "Ajay Devgn", 45),
            Employee(8, "Hrithik Roshan", 40),
            Employee(9, "Amitabh Bachchan", 31),
            Employee(10, "Akshay Kumar", 38),
            Employee(11, "Salman Khan", 39),
            Employee(12, "Shah Rukh Khan", 50),
        )
    }
}