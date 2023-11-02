package trash

import kotlinx.coroutines.*

fun main() = runBlocking {


}

//@Entity(tableName = "orders")
//data class Order(
//    @PrimaryKey(autoGenerate = true)
//    val orderId: Long = 0,
//    val orderNumber: String
//)
//
//@Entity(tableName = "deliveries")
//data class Delivery(
//    @PrimaryKey
//    val orderId: Long,
//    val deliveryAddress: String
//)
//
//data class OrderWithDelivery(
//    @Embedded
//    val order: Order,
//    @Relation(
//        parentColumn = "orderId",
//        entityColumn = "orderId"
//    )
//    val delivery: Delivery
//)
//
//
//
//
//
//
//
//
//@Dao
//interface OrderDeliveryDao {
//    @Insert
//    suspend fun insertOrder(order: Order)
//
//    @Insert
//    suspend fun insertDelivery(delivery: Delivery)
//
//    @Transaction
//    @Query("SELECT * FROM orders WHERE orderNumber = :orderNumber")
//    suspend fun getOrderWithDelivery(orderNumber: String): OrderWithDelivery
//}






