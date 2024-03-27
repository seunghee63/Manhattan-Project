import Foundation

class Node {
    var prev, next: Node?
    let key, value: Int

    init(key: Int, value: Int) {
        self.key = key
        self.value = value
    }
}

extension Node: CustomDebugStringConvertible {
    var debugDescription: String {
        "key: \(key), value: \(value)"
    }
}

class LFUCache {
    private let capacity: Int
    private var head: Node?
    private var tail: Node?
    private var caches = [Int: Node]()

    init(_ capacity: Int) {
        self.capacity = capacity
    }

    func get(_ key: Int) -> Int {
        guard let node = caches[key] else { return -1 }
        removeNode(node)
        appendNode(node)
        return node.value
    }

    func put(_ key: Int, _ value: Int) {
        if caches.count >= capacity {
            // remove invalidate
            removeTail()
        }

        let newNode = Node(key: key, value: value)
        if head == nil, tail == nil {
            head = newNode
            tail = newNode
        }

        if let node = caches[key] {
            removeCache(node)
        }

        caches[key] = newNode
        appendNode(newNode)

        print("--")
        print("!put - key: \(key), value: \(value)")
        print("caches: \(caches)")
        printCache()
    }

    private func appendNode(_ node: Node?) {
        head?.prev = node
        node?.next = head
        head = node
        tail?.next = nil
    }

    private func removeTail() {
        tail?.prev?.next = nil
        tail = tail?.prev
        removeCache(tail)
    }

    private func removeNode(_ node: Node?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    private func removeCache(_ node: Node?) {
        guard let node else { return }
        caches[node.key] = nil
    }

    private func printCache(){
        var curr = head
        while curr != nil {
            print(curr!)
            curr = curr?.next
        }
        print("\n-----")
    }
}

let cache = LFUCache(2)
cache.put(1,1)
cache.put(2,1)
cache.get(2)
cache.put(3,1)
cache.put(3,2)


/**
 * Your LFUCache object will be instantiated and called as such:
 * let obj = LFUCache(capacity)
 * let ret_1: Int = obj.get(key)
 * obj.put(key, value)
 */
