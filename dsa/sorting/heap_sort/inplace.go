package main

func inPlaceSort(arr []int) {
	for i := range len(arr) {
		siftUp(arr, i)
	}

	n := len(arr) - 1
	for range len(arr) - 1 {
		arr[0], arr[n] = arr[n], arr[0]
		n--
		siftDown(arr, n)
	}
}

func siftUp(arr []int, n int) {
	i := n
	for i > 0 {
		j := (i - 1) / 2
		if arr[j] < arr[i] {
			arr[i], arr[j] = arr[j], arr[i]
		}
		i = j
	}
}

func siftDown(arr []int, n int) {
	i := 0
	for 2*i+1 <= n {
		j := 2*i + 1
		if j+1 <= n && arr[j+1] > arr[j] {
			j = j + 1
		}

		if arr[i] >= arr[j] {
			break
		}

		arr[i], arr[j] = arr[j], arr[i]
		i = j
	}
}
