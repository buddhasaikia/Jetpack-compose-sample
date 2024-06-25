package com.example.jetpackcomposesample.customui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesample.data.Employee
import com.example.jetpackcomposesample.ui.theme.Typography

@Composable
fun EmployeeItem(employee: Employee) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            text = "Id: ${employee.id}",
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Name: ${employee.name}",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Age: ${employee.age}",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview
@Composable
fun Preview() {
    EmployeeItem(employee = Employee(1, "Rajesh Khanna", 30))
}