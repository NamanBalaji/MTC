#include "heap.h"
#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

static void sift_up(heap *h, size_t idx) {
  while (idx > 0) {
    size_t parent = (idx - 1) / 2;
    if (h->cmp(h->arr[idx], h->arr[parent]) >= 0) {
      break;
    }

    void *tmp = h->arr[idx];
    h->arr[idx] = h->arr[parent];
    h->arr[parent] = tmp;

    idx = parent;
  }
}

static void sift_down(heap *h, size_t idx) {
  while (2 * idx + 1 < h->size) {
    size_t j = 2 * idx + 1;
    if (j + 1 < h->size && h->cmp(h->arr[j + 1], h->arr[j]) < 0) {
      j++;
    }

    if (h->cmp(h->arr[idx], h->arr[j]) <= 0) {
      break;
    }

    void *tmp = h->arr[idx];
    h->arr[idx] = h->arr[j];
    h->arr[j] = tmp;

    idx = j;
  }
}

heap *heap_new(size_t capacity, int (*cmp)(const void *a, const void *b)) {
  heap *h = malloc(sizeof(heap));
  if (!h)
    return NULL;

  h->arr = malloc(sizeof(void *) * capacity);
  if (h->arr == NULL) {
    free(h);
    return NULL;
  }

  h->size = 0;
  h->capacity = capacity;
  h->cmp = cmp;

  return h;
}

void heap_free(heap *h) {
  if (!h)
    return;
  free(h->arr);
  free(h);
}

bool heap_peek(heap *h, void **out) {
  if (!h)
    return false;

  if (h->size == 0)
    return false;

  *out = h->arr[0];

  return true;
}

bool heap_insert(heap *h, void *a) {
  if (!h)
    return false;

  if (h->size == h->capacity) {
    void **tmp = realloc(h->arr, h->capacity * 2 * sizeof(void *));
    if (!tmp)
      return false;

    h->arr = tmp;
    h->capacity *= 2;
  }

  h->arr[h->size++] = a;
  sift_up(h, h->size - 1);

  return true;
}

void heap_remove(heap *h, void **out) {
  if (!heap_peek(h, out)) {
    return;
  }

  h->arr[0] = h->arr[--h->size];
  sift_down(h, 0);
}

bool heap_change_key(heap *h, size_t idx, void *val) {
  if (!h)
    return false;
  if (idx >= h->size)
    return false;

  h->arr[idx] = val;

  sift_up(h, idx);
  sift_down(h, idx);

  return true;
}

void print_heap(heap *h) {
  for (size_t i = 0; i < h->size; i++)
    printf("%d ", *(int *)h->arr[i]);
  printf("\n");
}
