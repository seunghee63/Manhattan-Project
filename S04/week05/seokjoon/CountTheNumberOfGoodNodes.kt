//2459ms, 139.6mb

class Solution {
   fun countGoodNodes(edges: Array<IntArray>): Int {
        val nodes = mutableMapOf<Int, MutableList<Int>>()
        // Good Node를 저장해두는 리스트
        val result = mutableListOf<Int>()

        //인접 리스트로 그래프를 만든다.      
        for (edge in edges) {
            val (u, v) = edge
            nodes.computeIfAbsent(edge[0]) { 
                mutableListOf() 
            }.add(edge[1])
             nodes.computeIfAbsent(edge[1]) { 
                mutableListOf() 
            }.add(edge[0])
        }
        dfs(0,-1,nodes,result)
        return result.size
    }

    fun dfs(
        index: Int,
        prevIndex : Int, // 부모 노드의 번호를 나타낸다.
        nodes: MutableMap<Int, MutableList<Int>>, 
        result: MutableList<Int>
    ): Int {
        // 루트 노트가 아닌 경우 , 해당 노드의 크기가 1인 경우는 부모와 연결된 경우만 있으므로
        // 더 이상 진행하지 않는다.
        // 이때 자식 노드가 없으므로 Good Node에 해당하여 result에 저장한다.
        if (prevIndex != -1 && nodes.containsKey(index) && nodes[index]!!.size == 1) {
            result.add(index)
            return 1
        }

        // 자식 노드의 노드 수의 합을 저장하는 리스트
        val list = mutableListOf<Int>()

        // 자식 노드를 순회하면서 dfs를 다시 돌면서 자식 노드의 수의 합을 구한다.
        nodes[index]!!.forEach { node ->
            // prevIndex는 부모 노드를 나타내므로 부모 노드는 돌지 않는다.
            if(prevIndex != node) list.add(dfs(node,index, nodes, result))
        }

        // 자식 노드들 각각 노드 수가 동일한지 set으로 바꾼뒤 사이즈가 1인지 체크한다.
        if (list.toSet().size == 1) {
            result.add(index)
        }

        // 자식 노드 수 + 자신
        return list.sum() + 1
    }
}
