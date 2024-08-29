class Solution {
    fun rob(houses: IntArray): Int {
        // 집이 없는 경우
        if (houses.isEmpty()) return 0

        var maxLootAtPreviousHouse = 0 // 직전 집까지의 최대 훔친 돈
        var maxLootAtTwoHousesBack = 0 // 전전 집까지의 최대 훔친 돈

        // 각 집마다 돈을 훔칠지 결정
        for (money in houses) {
            // 현재 집을 훔칠 경우/ 훔치지 않을 경우 중 최대값
            val currentMaxLoot = maxOf(maxLootAtTwoHousesBack + money, maxLootAtPreviousHouse)

            // 전전 집까지의 최대 돈
            maxLootAtTwoHousesBack = maxLootAtPreviousHouse
            // 직전 집까지의 최대 돈
            maxLootAtPreviousHouse = currentMaxLoot
        }

        // 마지막 집까지 훔쳤을 때 금액
        return maxLootAtPreviousHouse
    }
}
