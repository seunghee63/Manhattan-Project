class Solution {
    // 트리를 구성할 리스트
    private lateinit var tree: Array<MutableList<Int>>
    // 각 노드의 서브트리 크기를 저장할 배열
    private lateinit var subtreeSize: IntArray
    private var goodNodeCount = 0

    fun countGoodNodes(edges: Array<IntArray>): Int {
        val n = edges.size + 1 // 노드의 수(엣지의 수 + 1)

        tree = Array(n) { mutableListOf() }
        subtreeSize = IntArray(n)

        // 엣지 정보로 트리 구성 
        for (edge in edges) {
            tree[edge[0]].add(edge[1])
            tree[edge[1]].add(edge[0])
        }

        // DFS를 이용하여 서브트리 크기를 계산
        dfs(0, -1)

        return goodNodeCount
    }

    // 현재 노드와 부모 노드를 받아 서브트리 크기를 계산
    private fun dfs(current: Int, parent: Int): Int {
        var currentSubtreeSize = 1
        var isGoodNode = true
        var expectedSize = -1

        // 현재 노드의 자식들을 탐색
        for (neighbor in tree[current]) {
            if (neighbor == parent) continue // 부모 노드는 스킵

            val childSubtreeSize = dfs(neighbor, current)
            currentSubtreeSize += childSubtreeSize

            // 첫 번째 자식의 서브트리 크기를 기준으로..
            if (expectedSize == -1) {
                expectedSize = childSubtreeSize
            }
            // 이후 자식들의 서브트리 크기와 비교
            if (childSubtreeSize != expectedSize) {
                isGoodNode = false
            }
        }

        if (isGoodNode) goodNodeCount++

        subtreeSize[current] = currentSubtreeSize
        return currentSubtreeSize
    }
}
