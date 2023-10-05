package section_1

import kotlinx.coroutines.*
import java.lang.IllegalArgumentException

fun chapter5Exam01(): Unit = runBlocking {
    val job1 = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 1")
    }
    val job2 = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 2")
    }
}

fun chapter5Exam02(): Unit = runBlocking {
    val job = CoroutineScope(Dispatchers.Default).launch {
        throw IllegalArgumentException()
    }
    delay(1_000L)
}

fun chapter5Exam03(): Unit = runBlocking {
    val job = CoroutineScope(Dispatchers.Default).async {
        throw IllegalArgumentException()
    }
    delay(1_000L)
    job.await()
}

fun chapter5Exam04(): Unit = runBlocking {
    val job = async(SupervisorJob()) {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}

fun chapter5Exam05(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler {_, throwable ->
        printWithThread("예외")
        throw throwable
    }

    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}

fun main() {
    chapter5Exam05()
}
