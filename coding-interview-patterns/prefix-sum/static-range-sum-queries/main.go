// https://cses.fi/problemset/task/1646/
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

// Given an array of n integers, your task is to process q queries of the form: what is the sum of values in range [a,b]?
//
// Input
// 	The first input line has two integers n and q: the number of values and queries.
// 	The second line has n integers x_1,x_2,\dots,x_n: the array values.
// 	Finally, there are q lines describing the queries. Each line has two integers a and b: what is the sum of values in range [a,b]?
//
// Output
// 	Print the result of each query.
//
//
// Constraints
// 1 <= n,q <= 2 * 10^5
// 1 <= x_i <= 10^9
// 1 <= a <= b <= n
//
// Example
// 	Input:
// 		8 4
// 		3 2 4 5 1 1 5 3
// 		2 4
// 		5 6
// 		1 8
// 		3 3
//
// 	Output:
// 		11
// 		2
// 		24
//	 	4

var reader *bufio.Scanner

func readInt() int {
	reader.Scan()

	x, err := strconv.Atoi(reader.Text())
	if err != nil {
		log.Fatal(err)
	}

	return x
}

func main() {
	reader = bufio.NewScanner(os.Stdin)
	reader.Split(bufio.ScanWords)

	writer := bufio.NewWriter(os.Stdout)
	defer func() {
		_ = writer.Flush()
	}()

	n, q := readInt(), readInt()

	nums := make([]int, n)
	for i := range n {
		nums[i] = readInt()
	}

	queries := make([][]int, q)
	for i := range q {
		queries[i] = []int{readInt(), readInt()}
	}

	res := prefixSum(nums, queries)
	for _, num := range res {
		_, _ = fmt.Fprintf(writer, "%d\n", num)
	}
}

func prefixSum(nums []int, queries [][]int) []int {
	n := len(nums)

	ps := make([]int, n+1)
	for i := 1; i <= n; i++ {
		ps[i] += ps[i-1] + nums[i-1]
	}

	res := make([]int, len(queries))
	for i := range queries {
		r, l := queries[i][1]-1, queries[i][0]-1
		res[i] = ps[r+1] - ps[l]
	}

	return res
}
