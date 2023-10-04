package section_1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() : Unit = runBlocking { // 1번 코루틴
    printWithThread("START")
    launch {
        //  2번 코루틴
        newRoutine()
    }
    yield()
    printWithThread("END")
}

suspend fun newRoutine() {
    val num1 = 1
    val num2 = 2
    yield()
    printWithThread("${num1 + num2}")
}

fun printWithThread(str: Any) {
    println("[${Thread.currentThread().name}] $str")
    // editConfigurations -> VM options -> -Dkotlinx.coroutines.debug
}

