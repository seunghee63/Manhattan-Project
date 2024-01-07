package main

type Item struct {
	Key   int
	Value int
}

type LRUCache struct {
	Size     int
	Capacity int
	Cache    map[int]*Item
}

func Constructor(capacity int) LRUCache {
	return LRUCache{Size: 0, Capacity: capacity, Cache: map[int]*Item{}}
}

func (this *LRUCache) Get(key int) int {
	return this.Cache[key].Value
}

func (this *LRUCache) Put(key int, value int) {

}
