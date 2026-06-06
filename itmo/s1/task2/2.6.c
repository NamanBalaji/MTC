#include <assert.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int value;
  size_t min_idx;
  size_t max_idx;
} element;

typedef struct {
  size_t size;
  size_t cap;
  element **min_heap;
  element **max_heap;
} min_max;

static void set_idx(element *e, size_t idx, int sign) {
  if (sign > 0) {
    e->max_idx = idx;
  } else {
    e->min_idx = idx;
  }
}

static bool ordered(const element *a, const element *b, int sign) {
  return sign > 0 ? a->value >= b->value : a->value <= b->value;
}

static bool better(const element *a, const element *b, int sign) {
  return sign > 0 ? a->value > b->value : a->value < b->value;
}

static void heap_swap(element **heap, size_t i, size_t j, int sign) {
  element *tmp = heap[i];
  heap[i] = heap[j];
  heap[j] = tmp;

  set_idx(heap[i], i, sign);
  set_idx(heap[j], j, sign);
}

static size_t sift_up(element **heap, size_t i, int sign) {
  while (i > 0) {
    size_t parent = (i - 1) / 2;

    if (ordered(heap[parent], heap[i], sign)) {
      break;
    }

    heap_swap(heap, parent, i, sign);
    i = parent;
  }

  return i;
}

static size_t sift_down(element **heap, size_t i, size_t n, int sign) {
  for (;;) {
    size_t left = 2 * i + 1;

    if (left >= n) {
      break;
    }

    size_t best = left;
    size_t right = left + 1;

    if (right < n && better(heap[right], heap[left], sign)) {
      best = right;
    }

    if (ordered(heap[i], heap[best], sign)) {
      break;
    }

    heap_swap(heap, i, best, sign);
    i = best;
  }

  return i;
}

static void repair_at(element **heap, size_t i, size_t n, int sign) {
  if (i >= n) {
    return;
  }

  i = sift_up(heap, i, sign);
  sift_down(heap, i, n, sign);
}

static bool min_max_reserve(min_max *mm, size_t needed) {
  if (mm->cap >= needed) {
    return true;
  }

  size_t new_cap = mm->cap ? mm->cap : 1;

  while (new_cap < needed) {
    if (new_cap > SIZE_MAX / 2) {
      return false;
    }
    new_cap *= 2;
  }

  if (new_cap > SIZE_MAX / sizeof *mm->min_heap) {
    return false;
  }

  element **new_min = malloc(new_cap * sizeof *new_min);
  element **new_max = malloc(new_cap * sizeof *new_max);

  if (!new_min || !new_max) {
    free(new_min);
    free(new_max);
    return false;
  }

  for (size_t i = 0; i < mm->size; i++) {
    new_min[i] = mm->min_heap[i];
    new_max[i] = mm->max_heap[i];
  }

  free(mm->min_heap);
  free(mm->max_heap);

  mm->min_heap = new_min;
  mm->max_heap = new_max;
  mm->cap = new_cap;

  return true;
}

min_max *new_min_max(size_t capacity) {
  if (capacity == 0) {
    capacity = 1;
  }

  if (capacity > SIZE_MAX / sizeof(element *)) {
    return NULL;
  }

  min_max *mm = malloc(sizeof *mm);
  if (!mm) {
    return NULL;
  }

  mm->size = 0;
  mm->cap = capacity;
  mm->min_heap = malloc(capacity * sizeof *mm->min_heap);
  mm->max_heap = malloc(capacity * sizeof *mm->max_heap);

  if (!mm->min_heap || !mm->max_heap) {
    free(mm->min_heap);
    free(mm->max_heap);
    free(mm);
    return NULL;
  }

  return mm;
}

void min_max_free(min_max *mm) {
  if (!mm) {
    return;
  }

  for (size_t i = 0; i < mm->size; i++) {
    free(mm->min_heap[i]);
  }

  free(mm->min_heap);
  free(mm->max_heap);
  free(mm);
}

bool min_max_insert(min_max *mm, int value) {
  if (!mm) {
    return false;
  }

  if (!min_max_reserve(mm, mm->size + 1)) {
    return false;
  }

  element *e = malloc(sizeof *e);
  if (!e) {
    return false;
  }

  e->value = value;
  e->min_idx = mm->size;
  e->max_idx = mm->size;

  mm->min_heap[mm->size] = e;
  mm->max_heap[mm->size] = e;

  sift_up(mm->min_heap, mm->size, -1);
  sift_up(mm->max_heap, mm->size, 1);

  mm->size++;
  return true;
}

bool get_min(const min_max *mm, int *out) {
  if (!mm || mm->size == 0) {
    return false;
  }

  if (out) {
    *out = mm->min_heap[0]->value;
  }

  return true;
}

bool get_max(const min_max *mm, int *out) {
  if (!mm || mm->size == 0) {
    return false;
  }

  if (out) {
    *out = mm->max_heap[0]->value;
  }

  return true;
}

static void remove_from_heap(element **heap, size_t idx, size_t new_size,
                             int sign) {
  if (idx != new_size) {
    heap[idx] = heap[new_size];
    set_idx(heap[idx], idx, sign);
    heap[new_size] = NULL;
    repair_at(heap, idx, new_size, sign);
  } else {
    heap[new_size] = NULL;
  }
}

bool remove_min(min_max *mm, int *out) {
  if (!mm || mm->size == 0) {
    return false;
  }

  element *victim = mm->min_heap[0];
  size_t new_size = mm->size - 1;

  if (out) {
    *out = victim->value;
  }

  remove_from_heap(mm->min_heap, victim->min_idx, new_size, -1);
  remove_from_heap(mm->max_heap, victim->max_idx, new_size, 1);

  mm->size = new_size;
  free(victim);

  return true;
}

bool remove_max(min_max *mm, int *out) {
  if (!mm || mm->size == 0) {
    return false;
  }

  element *victim = mm->max_heap[0];
  size_t new_size = mm->size - 1;

  if (out) {
    *out = victim->value;
  }

  remove_from_heap(mm->max_heap, victim->max_idx, new_size, 1);
  remove_from_heap(mm->min_heap, victim->min_idx, new_size, -1);

  mm->size = new_size;
  free(victim);

  return true;
}

int main(void) {
  min_max *mm = new_min_max(0);
  assert(mm != NULL);

  int data[] = {5, 1, 9, 3, 7, 2, 8, 6, 4, 0, -1, 10, 10, 3};
  size_t n = sizeof(data) / sizeof(data[0]);

  for (size_t i = 0; i < n; i++) {
    assert(min_max_insert(mm, data[i]));
  }

  int x;

  assert(get_min(mm, &x) && x == -1);
  assert(get_max(mm, &x) && x == 10);

  assert(remove_min(mm, &x) && x == -1);
  assert(get_min(mm, &x) && x == 0);
  assert(get_max(mm, &x) && x == 10);

  assert(remove_max(mm, &x) && x == 10);
  assert(get_max(mm, &x) && x == 10);

  assert(remove_max(mm, &x) && x == 10);
  assert(get_max(mm, &x) && x == 9);

  int expected_min_order[] = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
  size_t m = sizeof(expected_min_order) / sizeof(expected_min_order[0]);

  for (size_t i = 0; i < m; i++) {
    assert(get_min(mm, &x));
    assert(x == expected_min_order[i]);
    assert(remove_min(mm, &x));
    assert(x == expected_min_order[i]);
  }

  assert(!get_min(mm, &x));
  assert(!get_max(mm, &x));
  assert(!remove_min(mm, &x));
  assert(!remove_max(mm, &x));

  min_max_free(mm);
  puts("all tests passed");
  return 0;
}
