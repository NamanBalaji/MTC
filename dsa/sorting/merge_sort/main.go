package main

import (
	"fmt"
)

// Complexity O(n)
func merge(a, b []int, less func(int, int) bool) []int {
	n, m := len(a), len(b)
	res := make([]int, n+m)

	i, j := 0, 0
	k := 0
	for i < n || j < m {
		if i == n || (j < m && less(b[j], a[i])) {
			res[k] = b[j]
			j++
		} else {
			res[k] = a[i]
			i++
		}

		k++
	}

	return res
}

// Complexity: O(n * log n)
func sort(a []int, less func(int, int) bool) []int {
	n := len(a)
	if n < 2 {
		return a
	}

	leftHalf, rightHalf := sort(a[:n/2], less), sort(a[n/2:], less)
	return merge(leftHalf, rightHalf, less)
}

func main() {
	a := []int{1, 4, 6, 2, 9, 10, 21, 3, 7, 17, 8, 14}
	a = sort(a, func(i, j int) bool {
		return i > j
	})

	fmt.Println(a)

	b := []int{1, 4, 6, 2, 9, 10, 21, 3, 7, 17, 8, 14}
	mergeSort(b)

	fmt.Println(b)
}
