val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(' ').map { it.toInt() }
    val N_arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()

    for (i in 1 until N) {
        N_arr[i] = N_arr[i - 1] + N_arr[i]
    }

    var answer = N_arr[K - 1]

    for (i in 0 until N - K) {
        answer = answer.coerceAtLeast(N_arr[i + K] - N_arr[i])
    }

    write("$answer")

    close()
}