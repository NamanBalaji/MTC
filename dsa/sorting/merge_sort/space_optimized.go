package main

func mergeOp(arr, tmp []int, lo, mid, hi int) {
	i, j, k := lo, mid+1, lo
	for i < mid+1 || j <= hi {
		if j > hi || (i < mid+1 && arr[i] < arr[j]) {
			tmp[k] = arr[i]
			i++
			k++

			continue
		}

		tmp[k] = arr[j]
		j++
		k++
	}

	for k := lo; k <= hi; k++ {
		arr[k] = tmp[k]
	}
}

func sortOp(arr, k []int, lo, hi int) {
	if hi <= lo {
		return
	}

	mid := lo + (hi-lo)/2
	sortOp(arr, k, lo, mid)
	sortOp(arr, k, mid+1, hi)

	mergeOp(arr, k, lo, mid, hi)
}

func mergeSort(arr []int) {
	if len(arr) < 2 {
		return
	}

	k := make([]int, len(arr))
	sortOp(arr, k, 0, len(arr)-1)
}
