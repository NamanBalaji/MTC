package main

type Heap[T any] struct {
	arr  []T
	less func(i, j int) bool
}

func NewHeap[T any](less func(int, int) bool) *Heap[T] {
	return &Heap[T]{
		arr:  make([]T, 0),
		less: less,
	}
}

func (h *Heap[T]) insert(val T) {
	h.arr = append(h.arr, val)
	i := len(h.arr) - 1
	for i > 0 && h.less(i, (i-1)/2) {
		j := (i - 1) / 2
		h.arr[i], h.arr[j] = h.arr[j], h.arr[i]
		i = j
	}
}

func (h *Heap[T]) peek() (T, bool) {
	var val T
	if len(h.arr) == 0 {
		return val, false
	}

	return h.arr[0], true
}

func (h *Heap[T]) remove() (T, bool) {
	var val T
	if len(h.arr) == 0 {
		return val, false
	}

	n := len(h.arr)
	h.arr[0], h.arr[n-1] = h.arr[n-1], h.arr[0]

	i := 0
	for 2*i+1 < n-1 {
		j := 2*i + 1
		if j+1 < n-1 && h.less(j+1, j) {
			j = j + 1
		}

		if !h.less(j, i) {
			break
		}
		h.arr[i], h.arr[j] = h.arr[j], h.arr[i]

		i = j
	}

	val = h.arr[n-1]
	h.arr = h.arr[:n-1]

	return val, true
}
