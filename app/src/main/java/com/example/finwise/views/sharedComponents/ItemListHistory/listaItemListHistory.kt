package com.example.finwise.views.sharedComponents.ItemListHistory

data class itemListHistoryData(
    val category: String,
    val value: String,
    val icon: Int
)


object listaItemListHistory {
    var lista = listOf(
        itemListHistoryData("Salary", "$4.000,00", com.example.finwise.R.drawable.icon_salary_blue),
        itemListHistoryData("Groceries", "-$100,00", com.example.finwise.R.drawable.icon_salary_blue),
        itemListHistoryData("Rent", "-$674,40", com.example.finwise.R.drawable.icon_salary_blue),
    )

}