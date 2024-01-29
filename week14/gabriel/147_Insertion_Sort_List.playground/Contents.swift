import UIKit

/*
 1005 ms Beats
 45.26% of users with Swift
 */

//  Definition for singly-linked list.
public class ListNode: CustomDebugStringConvertible {
    public var debugDescription: String {
        "val: \(val)"
    }

    public var val: Int
    public var next: ListNode?
    public init() { self.val = 0; self.next = nil; }
    public init(_ val: Int) { self.val = val; self.next = nil; }
    public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }

    
}

class Solution {
    func insertionSortList(_ head: ListNode?) -> ListNode? {
        guard let head else { return nil }
        var recordArr = [ListNode]()
        var next = head.next
        recordArr.append(head)

        while next != nil {
            var curRecordIndex = recordArr.count-1
            var cur = next
            next = next?.next
            for (index, node) in recordArr.enumerated().reversed() {

                if cur!.val < recordArr[index].val {
                    recordArr[index].next = cur!.next
                    cur?.next = recordArr[index]

                    if index == recordArr.count - 1 {
                        let temp = recordArr[index]
                        recordArr[index] = cur!
                        recordArr.append(temp)
                    } else {
                        let temp = recordArr[index]
                        recordArr[index] = recordArr[curRecordIndex]
                        recordArr[curRecordIndex] = temp
                    }

                    if index > 0 {
                        let prevNode = recordArr[index-1]
                        prevNode.next = cur
                        cur = recordArr[index]
                        curRecordIndex = index
                    }

                } else {
                    if index == recordArr.count - 1 {
                        recordArr.append(cur!)
                    }
                    break
                }
            }
        }
        return recordArr.first
    }
}

let node = ListNode(4)
let node2 = ListNode(2)
let node3 = ListNode(1)
let node4 = ListNode(3)

node.next = node2
node2.next = node3
node3.next = node4

Solution().insertionSortList(node)
