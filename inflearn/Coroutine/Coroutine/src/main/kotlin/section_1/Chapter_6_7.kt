package section_1

import kotlinx.coroutines.*
import java.lang.IllegalArgumentException

fun chapter6Exam01(): Unit = runBlocking {
    launch {
        delay(600L)
        printWithThread("A")
    }

    launch {
        delay(500L)
        throw IllegalArgumentException("코루틴 실패!!")
    }
}

class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {
            // 코루틴이 시작되어 작업을 시작함
        }
    }

    fun destroy() {
        scope.cancel()
    }
}

fun chapter6Exam02(): Unit = runBlocking {
    CoroutineName("나만의 코루틴 ") + Dispatchers.Default
}

suspend fun chapter6Exam03() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 1")
//        coroutineContext + CoroutineName("")
//        coroutineContext.minusKey()
    }

    job.join()
}

fun main() {
    chapter6Exam01()
}
