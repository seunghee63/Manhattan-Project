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
	if cache.capacity == 0 {
		return
	}

	if item, exists := cache.items[key]; exists {
		data := item.Value.(Item)
		data.Val = value
		cache.increaseCount(data, key)
		return
	}

	if cache.IsFull() {
		cache.evict()
	}

	cache.add(key, value)
}

func (cache *LFUCache) IsFull() bool {
	return cache.size == cache.capacity
}

func (cache *LFUCache) evict() {
	li := cache.counter[cache.minCount]
	evicted := li.Remove(li.Front()).(Item)

	delete(cache.items, evicted.Key)
	if li.Len() == 0 {
		delete(cache.counter, cache.minCount)
	}

	cache.size--
}

func (cache *LFUCache) add(key, val int) {
	item := NewItem(key, val)
	cache.addToCounter(1, item, key)
	cache.minCount = 1
	cache.size++
}

func (cache *LFUCache) addToCounter(count int, item Item, key int) {
	if _, exists := cache.counter[count]; !exists {
		cache.counter[count] = list.New()
	}
	cache.items[key] = cache.counter[count].PushBack(item)
}

func NewItem(key, val int) Item {
	return Item{
		Key:  key,
		Val:  val,
		Count: 1,
	}
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
