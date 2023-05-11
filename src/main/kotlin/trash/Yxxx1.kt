package trash



data class CurrencyRates(val euroToDollar: Double, val euroToRuble: Double)

enum class CurrencyType{
    EURO,
    DOLLAR,
    RUBLE
}

class PriceHandler {

    fun getPrice(type: CurrencyType): Double{
        val priceEuro = getPriceEuro()
        val currencyRate = getCurrencyRate()

        return when(type){
            CurrencyType.EURO -> priceEuro
            CurrencyType.DOLLAR -> priceEuro * currencyRate.euroToDollar
            CurrencyType.RUBLE -> priceEuro * currencyRate.euroToRuble
        }
    }

    private fun getPriceEuro(): Double{
        //
        return 25.0
    }

    private fun getCurrencyRate(): CurrencyRates{
        return CurrencyRates(0.90, 75.0)
    }
}
fun main() {

    val x = PriceHandler()
    println(x.getPrice(CurrencyType.RUBLE))

}



