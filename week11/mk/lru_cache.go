// 438ms, 71.86mb
package main

type LRUCache struct {
	Head, Tail *Item
	Cache      map[int]*Item
	Capacity   int
}

func newLRUCache(head, tail *Item, cap int) LRUCache {
	return LRUCache{
		Head:     head,
		Tail:     tail,
		Cache:    make(map[int]*Item),
		Capacity: cap,
	}
}

type Item struct {
	Prev, Next *Item
	Key, Value int
}

func newItem(key, val int) *Item {
	return &Item{
		Key:   key,
		Value: val,
	}
}

func Constructor(capacity int) LRUCache {
	head, tail := newItem(0, 0), newItem(0, 0)

	head.Next = tail
	tail.Prev = head
	return newLRUCache(head, tail, capacity)
}

func (this *LRUCache) Get(key int) int {
	if n, ok := this.Cache[key]; ok {
		this.remove(n)
		this.insert(n)
		return n.Value
	}

	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if _, ok := this.Cache[key]; ok {
		this.remove(this.Cache[key])
	}

	if len(this.Cache) == this.Capacity {
		this.remove(this.Tail.Prev)
	}

	this.insert(newItem(key, value))
}

func (this *LRUCache) remove(Item *Item) {
	delete(this.Cache, Item.Key)
	Item.Prev.Next = Item.Next
	Item.Next.Prev = Item.Prev
}

func (this *LRUCache) insert(Item *Item) {
	this.Cache[Item.Key] = Item
	next := this.Head.Next
	this.Head.Next = Item
	Item.Prev = this.Head
	next.Prev = Item
	Item.Next = next
}
