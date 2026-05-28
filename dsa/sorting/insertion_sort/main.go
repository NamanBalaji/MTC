package main

import "fmt"

// TimeComplexity O(n^2)
func insertionSort(a []int, less func(a, b int) bool) {
	for i := range len(a) {
		j := i
		for j > 0 && less(j, j-1) {
			a[j], a[j-1] = a[j-1], a[j]
			j--
		}
	}
}

func main() {
	arr := []int{10, 3, 7, 5, 11, 2, 4}
	insertionSort(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	fmt.Println(arr)
}
