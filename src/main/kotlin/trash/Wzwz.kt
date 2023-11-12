package trash



import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import java.util.*

//==================================================================





// []     0
// [00]   0
// [901]  0
// [09]   0

//   v    v
// [186254837]
//  012345678

// наибольшее расстояние
// наибольшая высота

//8-0 * 7 || 1
//7-1 * 8 || 3
//

//val flow1 = flowOf("A", "B", "C")
//    .onEach { delay(400) }
//val flow2 = flowOf(1, 2, 3, 4)
//    .onEach { delay(1000) }
//
//flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
//.collect { println(it) }



