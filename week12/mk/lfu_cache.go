package main

import "container/list"

type LFUCache struct {
	size     int
	capacity int
	counter  map[int]*list.List
	items    map[int]*list.Element
	minCount int
}

type Item struct {
	Key   int
	Val   int
	Count int
}

func Constructor(capacity int) LFUCache {
	return LFUCache{
		capacity: capacity,
		counter:  make(map[int]*list.List),
		items:    make(map[int]*list.Element),
	}
}

func (cache *LFUCache) Get(key int) int {
	item, exists := cache.items[key]
	if !exists {
		return -1
	}

	value := item.Value.(Item)
	cache.increaseCount(value, key)

	return value.Val
}

func (cache *LFUCache) increaseCount(item Item, key int) {
	li := cache.counter[item.Count] // 0
	li.Remove(cache.items[key])     // 0
	if cache.minCount == item.Count && li.Len() == 0 {
		cache.minCount++ // 1
	}
	newItem := Item{Count: item.Count + 1, Val: item.Val, Key: item.Key}

	newCountList, exists := cache.counter[newItem.Count]
	if exists {
		newCountList.PushBack(newItem)
		return
	}

	newLi := list.New()
	newLi.PushBack(newItem)
	cache.counter[newItem.Count] = newLi
}

func (cache *LFUCache) Put(key int, value int) {
	newItem := Item{Count: 0, Key: key, Val: value}
	if cache.size == cache.capacity {
		cache.removeItem(cache.minCount)
	}

	cache.addItem(newItem)
}

func (cache *LFUCache) addItem(item Item) {
	newCountList, exists := cache.counter[item.Count]
	if !exists {
		cache.counter[item.Count] = list.New()
		return
	}

	cache.items[item.Key] = newCountList.PushBack(item)
	cache.size++
}

func (cache *LFUCache) removeItem(key int) {
	removedTarget := cache.items[key]
	removedTargetList := cache.counter[key]
	removedTargetList.Remove(removedTarget)
	delete(cache.items, key)
	cache.size--
	cache.minCount = 0
}

func main() {

}
