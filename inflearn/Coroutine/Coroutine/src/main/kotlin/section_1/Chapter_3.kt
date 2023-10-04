package section_1

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun exampleRunBlocking(){
    runBlocking {
        printWithThread("START")
        launch {
            delay(2_000L)
            printWithThread("LAUNCH END")
        }
    }

    printWithThread("END")
}

fun exampleLaunchJobStart(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {// start를 해야 시작함
        printWithThread("Hello launch")
    }

    delay(1_000L)
    job.start()
}

fun exampleLaunchJobCancel() : Unit = runBlocking {
    val job = launch {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }

    delay(1_000L)
    job.cancel()
}

fun exampleLaunchJobJoin() : Unit = runBlocking {
    val job1 = launch {
        delay(1_000L)
        printWithThread("Job 1")
    }
    job1.join() // join을 사용하면 job1이 끝난 후 job2가 실행됨

    val job2 = launch {
        delay(1_000L)
        printWithThread("Job 2")
    }
}

fun exampleAsync() : Unit = runBlocking {
    val job = async {
        3 + 5
    }

    val eight = job.await() // await() : async 결과를 가져오는 함수
    printWithThread(eight)
}

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val job1 = async { apiCall1() }
        val job2 = async { apiCall2() }
        printWithThread(job1.await() + job2.await())
    }
    printWithThread("소요 시간 : $time ms")
}

suspend fun apiCall1(): Int {
    delay(1_000L)
    return 1
}

suspend fun apiCall2(): Int {
    delay(1_000L)
    return 2
}
