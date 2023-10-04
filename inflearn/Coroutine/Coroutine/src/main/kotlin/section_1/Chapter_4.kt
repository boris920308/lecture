package section_1

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    val job = launch {
        try {
          delay(1_00L)
        } catch (e: CancellationException) {
            // 아무것도 안함
        } finally {
            // 필요한 자원을 받을 수 있음
        }

        printWithThread("취소되지 않음!")
    }

    delay(100L)
    printWithThread("start cancel")
    job.cancel()
}


fun chapter4Exam2(): Unit = runBlocking {
    val job = launch(Dispatchers.Default) { // 코루틴을 다른 스레드에 배정
        var i = 1
        var nextPrintTime = System.currentTimeMillis()

        while (i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithThread("${i++}번째 출력!")
                nextPrintTime += 1_000L
            }

            if (!isActive) { // 현재 코루틴이 활성화 되어 있는지, 취소신호를 받았는지 확인
                throw CancellationException()
            }
        }
    }

    delay(100L)
    job.cancel()
}

fun chapter4Exam1(): Unit = runBlocking {
    val job1 = launch {
        delay(1_000L)
        printWithThread("Job 1")
    }

    val job2 = launch {
        delay(1_000L)
        printWithThread("Job 2")
    }

    delay(100)
    job1.cancel()
}