class Solution {
    // Runtime : 162ms(95.65%)
    // Memory : 37.41MB(36.23%)
    // Time : 3:40:22
    fun nonSpecialCount(l: Int, r: Int): Int {
        val n = sqrt(r.toDouble()).toInt() // r의 제곱근을 구하고 이를 정수로 변환하여 변수 n에 저장
        // n은 r 이하의 최대 정수 제곱근을 의미함
        
        // 크기 n+1의 불리언 배열 isPrime을 생성하고 모든 값을 true로 초기화
        val isPrime = BooleanArray(n + 1).apply { fill(true) }
        // 이 배열은 특정 수가 소수인지 아닌지를 판단하기 위해 사용됨

        // specialNumber 개수를 세기 위한 변수 count
        var count = 0

        for (i in 2..n) {
            if (isPrime[i]) { // i가 소수인지 확인 (소수인 경우 isPrime[i]가 true)

                if (i * i in l..r) count++ // i^2이 범위 [l, r] 내에 있으면 count를 1 증가시킴

                var j = i
                while (j <= n) {
                    isPrime[j] = false // 소수 i의 배수를 모두 false로 표시하여, 소수가 아님을 나타냄 (에라토스테네스의 체)
                    j += i 
                }
            }
        }
        // 범위 [l, r]의 전체 숫자 개수에서 제곱수의 개수를 빼서 반환
        return r - l + 1 - count
    }
}
