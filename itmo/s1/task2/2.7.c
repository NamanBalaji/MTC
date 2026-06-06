#include "heap.h"

#include <assert.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
  heap *min_heap;
  heap *max_heap;
  size_t size;
} median;

int cmp_min(const void *a, const void *b) {
  const int *x = a;
  const int *y = b;

  if (*x < *y)
    return -1;
  if (*x > *y)
    return 1;

  return 0;
}

int cmp_max(const void *a, const void *b) {
  const int *x = a;
  const int *y = b;

  if (*x > *y)
    return -1;
  if (*x < *y)
    return 1;

  return 0;
}

median *new_median(size_t cap) {
  median *med = malloc(sizeof *med);
  if (!med) {
    return NULL;
  }

  med->min_heap = heap_new(cap, cmp_min);
  med->max_heap = heap_new(cap, cmp_max);
  med->size = 0;

  if (!med->min_heap || !med->max_heap) {
    heap_free(med->min_heap);
    heap_free(med->max_heap);
    free(med);
    return NULL;
  }

  return med;
}

void normalize(median *m) {
  if (m->size == 0)
    return;

  size_t min_len = m->min_heap->size;
  size_t max_len = m->max_heap->size;

  if ((max_len == min_len) || (max_len == min_len + 1))
    return;

  if (min_len > max_len) {
    int *out;
    heap_remove(m->min_heap, (void **)&out);
    heap_insert(m->max_heap, out);

    return;
  }

  int *out;
  heap_remove(m->max_heap, (void **)&out);
  heap_insert(m->min_heap, out);
}

bool insert(median *m, int *value) {
  if (!m) {
    return false;
  }

  if (m->size == 0) {
    if (!heap_insert(m->max_heap, value)) {
      return false;
    }

    m->size++;
    return true;
  }

  int *max_peek;
  heap_peek(m->max_heap, (void **)&max_peek);

  if (*max_peek >= *value) {
    if (!heap_insert(m->max_heap, value)) {
      return false;
    }
  } else {
    if (!heap_insert(m->min_heap, value)) {
      return false;
    }
  }

  m->size++;
  normalize(m);
  return true;
}

bool get_median(median *m, float *out) {
  if (!m || !out) {
    return false;
  }

  if (m->size == 0) {
    return false;
  }

  int *max_top;
  heap_peek(m->max_heap, (void **)&max_top);

  if (m->size % 2 == 1) {
    *out = (float)*max_top;
    return true;
  }

  int *min_top;
  heap_peek(m->min_heap, (void **)&min_top);

  *out = ((float)*max_top + (float)*min_top) / 2.0f;
  return true;
}

bool remove_median(median *m, float *out) {
  if (!get_median(m, out)) {
    return false;
  }

  int *max_top;
  heap_remove(m->max_heap, (void **)&max_top);
  free(max_top);

  if (m->size % 2 == 0) {
    int *min_top;
    heap_remove(m->min_heap, (void **)&min_top);
    free(min_top);

    m->size--;
  }

  m->size--;
  normalize(m);

  return true;
}

void median_free(median *m) {
  if (!m) {
    return;
  }

  for (size_t i = 0; i < m->max_heap->size; i++) {
    free(m->max_heap->arr[i]);
  }

  for (size_t i = 0; i < m->min_heap->size; i++) {
    free(m->min_heap->arr[i]);
  }

  heap_free(m->max_heap);
  heap_free(m->min_heap);
  free(m);
}

static int *new_int(int value) {
  int *p = malloc(sizeof *p);
  assert(p != NULL);
  *p = value;
  return p;
}

int main(void) {
  median *m = new_median(4);
  assert(m != NULL);

  int values[] = {5, 15, 1, 3, 8, 7, 9};
  float expected[] = {5.0f, 10.0f, 5.0f, 4.0f, 5.0f, 6.0f, 7.0f};

  size_t n = sizeof values / sizeof values[0];

  for (size_t i = 0; i < n; i++) {
    int *value = new_int(values[i]);

    assert(insert(m, value));

    float med;
    assert(get_median(m, &med));

    printf("inserted %d, median = %.2f\n", values[i], med);

    assert(med == expected[i]);
  }

  printf("\nFinal heaps:\n");

  printf("max_heap lower half: ");
  print_heap(m->max_heap);

  printf("min_heap upper half: ");
  print_heap(m->min_heap);

  float med;
  assert(get_median(m, &med));
  printf("final median = %.2f\n", med);

  printf("\nRemoving medians:\n");

  while (remove_median(m, &med)) {
    printf("removed median = %.2f\n", med);
  }

  median_free(m);

  printf("all tests passed\n");
  return 0;
}
