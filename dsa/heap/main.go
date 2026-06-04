package main

import "fmt"

func main() {
	fmt.Println("=== Min Heap Test ===")

	var minHeap *Heap[int]
	minHeap = NewHeap[int](func(i, j int) bool {
		return minHeap.arr[i] < minHeap.arr[j]
	})

	values := []int{5, 3, 8, 1, 2, 9, 4}

	fmt.Println("Inserting:", values)
	for _, v := range values {
		minHeap.insert(v)
		fmt.Printf("insert(%d) -> heap: %v\n", v, minHeap.arr)
	}

	if v, ok := minHeap.peek(); ok {
		fmt.Println("peek() ->", v)
	}

	fmt.Println("Removing from min heap:")
	for {
		v, ok := minHeap.remove()
		if !ok {
			break
		}
		fmt.Printf("remove() -> %d, heap now: %v\n", v, minHeap.arr)
	}

	fmt.Println()
	fmt.Println("=== Max Heap Test ===")

	var maxHeap *Heap[int]
	maxHeap = NewHeap[int](func(i, j int) bool {
		return maxHeap.arr[i] > maxHeap.arr[j]
	})

	fmt.Println("Inserting:", values)
	for _, v := range values {
		maxHeap.insert(v)
		fmt.Printf("insert(%d) -> heap: %v\n", v, maxHeap.arr)
	}

	if v, ok := maxHeap.peek(); ok {
		fmt.Println("peek() ->", v)
	}

	fmt.Println("Removing from max heap:")
	for {
		v, ok := maxHeap.remove()
		if !ok {
			break
		}
		fmt.Printf("remove() -> %d, heap now: %v\n", v, maxHeap.arr)
	}

	fmt.Println()
	fmt.Println("=== Empty Heap Test ===")

	v, ok := minHeap.peek()
	fmt.Printf("minHeap.peek() on empty -> value: %d, ok: %v\n", v, ok)

	v, ok = minHeap.remove()
	fmt.Printf("minHeap.remove() on empty -> value: %d, ok: %v\n", v, ok)
}
