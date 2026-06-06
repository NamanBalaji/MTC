#include "heap.h"
#include <stdio.h>
#include <stdlib.h>

static int cmp_int(const void *a, const void *b) {
  return *(int *)a - *(int *)b;
}

int main(void) {
  int vals[] = {10, 20, 30, 40, 50};
  heap *h = heap_new(8, cmp_int);

  for (int i = 0; i < 5; i++)
    heap_insert(h, &vals[i]);

  printf("initial:       ");
  print_heap(h);

  /* decrease root key: 10 -> 1, should stay at root */
  int small = 1;
  heap_change_key(h, 0, &small);
  printf("after 10->1:   ");
  print_heap(h);

  void *top;
  heap_peek(h, &top);
  printf("peek (expect 1): %d\n", *(int *)top);

  /* increase root key: 1 -> 100, should sift down */
  int large = 100;
  heap_change_key(h, 0, &large);
  printf("after 1->100:  ");
  print_heap(h);

  heap_peek(h, &top);
  printf("peek (expect 20): %d\n", *(int *)top);

  /* drain heap — should come out in sorted order */
  printf("sorted output: ");
  while (h->size > 0) {
    void *out;
    heap_remove(h, &out);
    printf("%d ", *(int *)out);
  }
  printf("\n");

  heap_free(h);
  return 0;
}
