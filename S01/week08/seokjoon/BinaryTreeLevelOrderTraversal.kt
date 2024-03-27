//218ms, 38.3mb

import java.util.ArrayDeque

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root?.let { node ->
            return bfs(node)
        }    

    
        return listOf()
    }

    private fun bfs(root : TreeNode) : MutableList<MutableList<Int>> {
        
        val queue : Queue<Pair<TreeNode,Int>> = ArrayDeque()
        val resultQueue : Queue<Pair<TreeNode,Int>> = ArrayDeque()
        
        var maxLevel = 0

        resultQueue.add(Pair(root,0))
        queue.add(Pair(root,0))

        while(queue.isNotEmpty()){
            val (node, level) = queue.poll()
            maxLevel = max(level,maxLevel)
            node.left?.let {
                queue.add(Pair(it, level+1))
                resultQueue.add(Pair(it,level+1))
            }

            node.right?.let {
                queue.add(Pair(it, level+1))
                resultQueue.add(Pair(it,level+1))
            }            
        }
        val result : MutableList<MutableList<Int>> = mutableListOf()
        
        for(i in 0 .. maxLevel){
            result.add(mutableListOf())
        }

        while(resultQueue.isNotEmpty()){
            val (node, level) = resultQueue.poll()
            result[level].add(node.`val`)
        }

        return result
    }
}
