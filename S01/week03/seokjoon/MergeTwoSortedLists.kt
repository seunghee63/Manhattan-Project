//147ms / 35.71mb

class Solution {
    
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var resultNode : ListNode? = null
        var curResultNode = resultNode
        var curNode1 = list1
        var curNode2 = list2
        
        while(curNode1 != null || curNode2 != null){
            if(curNode1 != null && curNode2 != null){
                if(curNode1!!.`val` >= curNode2!!.`val`){
                    if(resultNode == null){
                        resultNode = curNode2
                        curResultNode = resultNode
                    }
                    else{
                        curResultNode?.next = curNode2
                        curResultNode = curResultNode?.next
                    }
                    curNode2 = curNode2?.next
                }else{
                    if(resultNode == null){
                        resultNode = curNode1
                        curResultNode = resultNode
                    }
                    else{
                        curResultNode?.next =  curNode1
                        curResultNode = curResultNode?.next
                    }
                    curNode1 = curNode1?.next
                }
            }else if(curNode1 == null){
                if(resultNode == null) resultNode = curNode2
                else curResultNode?.next = curNode2
                break
            }else {
                if(resultNode == null) resultNode= curNode1
                else curResultNode?.next = curNode1
                break
            }
        }
      return resultNode
    }
}
