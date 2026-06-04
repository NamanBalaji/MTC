package main

import "container/heap"

type minHeap []int

func (m minHeap) Less(i, j int) bool {
	return m[i] < m[j]
}

func (m minHeap) Swap(i, j int) {
	m[i], m[j] = m[j], m[i]
}

func (m minHeap) Len() int {
	return len(m)
}

func (m *minHeap) Push(x any) {
	*m = append(*m, x.(int))
}

func (m *minHeap) Pop() any {
	old := *m
	x := old[len(old)-1]
	*m = old[:len(old)-1]

	return x
}

func sort(a []int) {
	pq := make(minHeap, 0)
	heap.Init(&pq)
	for i := range len(a) {
		heap.Push(&pq, a[i])
	}

	for i := range len(a) {
		x := heap.Pop(&pq).(int)
		a[i] = x
	}
}
