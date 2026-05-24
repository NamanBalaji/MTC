// https://cses.fi/problemset/task/1652
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

// You are given an n * n grid representing the map of a forest. Each square is either empty or contains a tree.
// The upper-left square has coordinates (1,1), and the lower-right square has coordinates (n,n).
// Your task is to process q queries of the form: how many trees are inside a given rectangle in the forest?
//
// 	Input
// 		The first input line has two integers n and q: the size of the forest and the number of queries.
// 		Then, there are n lines describing the forest. Each line has n characters: . is an empty square and * is a tree.
// 		Finally, there are q lines describing the queries. Each line has four integers y_1, x_1, y_2, x_2 corresponding to the corners of a rectangle.
//
// 	Output
// 		Print the number of trees inside each rectangle.
//
// 	Constraints
// 		1 <= n <= 1000
// 		1 <= q <= 2 * 10^5
// 		1 <= y_1 <= y_2 <= n
// 		1 <= x_1 <= x_2 <= n
//
// 	Example
// 		Input:
// 			4 3
// 			.*..
// 			*.**
// 			**..
// 			****
// 			2 2 3 4
// 			3 1 3 1
// 			1 1 2 2
//
//
// 		Output:
// 			3
// 			1
// 			2

type Query struct {
	start, end []int
}

func readNum(reader *bufio.Scanner) int {
	reader.Scan()
	x, err := strconv.Atoi(reader.Text())
	if err != nil {
		log.Fatal(err)
	}

	return x
}

func readInput() ([][]int, []Query) {
	reader := bufio.NewScanner(os.Stdin)
	reader.Split(bufio.ScanWords)

	numRows, numQueries := readNum(reader), readNum(reader)

	forest := make([][]int, numRows)
	for i := range numRows {
		forest[i] = make([]int, numRows)
		reader.Scan()
		rowLine := reader.Text()
		for j, ch := range rowLine {
			forest[i][j] = 0
			if ch == '*' {
				forest[i][j] = 1
			}
		}
	}

	queries := make([]Query, numQueries)
	for i := range numQueries {
		start, end := make([]int, 2), make([]int, 2)
		start[0], start[1], end[0], end[1] = readNum(reader), readNum(reader), readNum(reader), readNum(reader)
		queries[i] = Query{start, end}
	}

	return forest, queries
}

func main() {
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	forest, queries := readInput()

	for _, r := range numTrees(forest, queries) {
		fmt.Fprintf(w, "%d\n", r)
	}
}

func numTrees(forest [][]int, queries []Query) []int {
	n := len(forest)

	p := make([][]int, n+1)
	for i := range n + 1 {
		p[i] = make([]int, n+1)
		for j := range n + 1 {
			if i == 0 || j == 0 {
				p[i][j] = 0
				continue
			}

			p[i][j] = p[i][j-1] + p[i-1][j] + forest[i-1][j-1] - p[i-1][j-1]
		}
	}

	res := make([]int, len(queries))

	for i, q := range queries {
		si, sj := q.start[0], q.start[1]
		ei, ej := q.end[0], q.end[1]

		res[i] = p[ei][ej] + p[si-1][sj-1] - p[si-1][ej] - p[ei][sj-1]
	}

	return res
}
