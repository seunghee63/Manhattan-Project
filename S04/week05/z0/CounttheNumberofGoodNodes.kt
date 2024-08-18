class Solution {
    // https://leetcode.com/problems/count-the-number-of-good-nodes/
    // Runtime : 1489ms(84.78%)
    // Memory : 119.23MB(93.48%)
    // Time taken: 5 hrs 2 m 1 s
    lateinit var tree : Array<MutableList<Int>>     // 트리 구조
    lateinit var childSize: IntArray                // [root] = 자식 노드 count
    fun countGoodNodes(edges: Array<IntArray>): Int {
        tree = Array(edges.size + 1) { mutableListOf() }
        childSize = IntArray(edges.size + 1)

        // 1) 부모 자식 트리구조 구현하기
        edges.forEach { ints ->
            tree[ints[0]].add(ints[1])
            tree[ints[1]].add(ints[0])
            // 부모가 자식보다 항상 작은 값이라는 보장이 없기 때문에, 부모 자식 노드에 서로 값을 저장해둔다
        }

        // 2) tree 어레이를 순회하면서 노드의 자식 노드 갯수를 세어 childSize에 저장한다.
        countChildSize(0, -1)

        // 3) 다시 tree 어레이를 순회하면서 자식 노드의 갯수를 비교하여 GoodNode인 경우의 수를 센다.
        var isGoodNode = true
        var result = 0
        tree.forEachIndexed { i, ints -> // i: 현재 노드 / ints: 자식노드 list
            isGoodNode = true
            if(childSize[i] <= 1) {    
                // 자식 노드가 없거나 1개만 있을 경우 GoodNode로 간주한다.
                result++
            } else {
                run loop@ {
                    // reduce 함수를 통해 연달아 있는 2개 값을 취한다
                    ints.reduce { n1, n2 ->
                        if(childSize[n1] < childSize[i]) { // 현재 노드의 자식 갯수보다 작은 값만 걸러서 비교한다
                            if(isGoodNode && childSize[n1] != childSize[n2]) {
                                isGoodNode = false
                                return@loop
                            }
                        }
                        n2
                    }
                }
                if(isGoodNode) result++ // GoodNode인 경우 count++
            }
        }
        return result
    }

    private fun countChildSize(level: Int, parent: Int): Int {
        var childCount = 0
        tree[level].forEach {
            if(it != parent) {
                childCount++
                childCount += countChildSize(it, level) // 모든 자식 노드를 순회하면서 카운트 한다
            }
        }
        childSize[level] = childCount
        return childCount
    }
}
