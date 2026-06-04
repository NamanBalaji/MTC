package main

import "fmt"

func main() {
	a := []int{5, 7, 2, 4, 3, 8, 9, 20, 11, 17, 18}
	sort(a)
	fmt.Println(a)

	b := []int{5, 7, 2, 4, 3, 8, 9, 20, 11, 17, 18}
	inPlaceSort(b)
	fmt.Println(b)
}
