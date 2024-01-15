package main

import "container/list"

type LFUCache struct {
	size     int
	capacity int
	counter     map[int]*list.List
	items     map[int]*list.Element
}

type Item struct {
	Key  int
	Val  int
	Count int
}


func Constructor(capacity int) LFUCache {
	return LFUCache{
		capacity: capacity,
		counter:     make(map[int]*list.List),
		items:     make(map[int]*list.Element),
	}
}


func (cache *LFUCache) Get(key int) int {
	item, exists := cache.items[key]
	if !exists {
		return -1
	}

	value := item.Value.(Item)
	cache.incrementCount(value, key)

	return value.Val
}

func (cache *LFUCache) incrementCount(item Item, key int) {
	list := cache.counter[item.Count]
	list.Remove(cache.items[key])

	...
}


func (this *LFUCache) Put(key int, value int)  {

}

func main() {

}

