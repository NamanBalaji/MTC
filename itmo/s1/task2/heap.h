#include <stdbool.h>
#include <stddef.h>

typedef struct {
  size_t size;
  size_t capacity;
  void **arr;
  int (*cmp)(const void *a, const void *b);
} heap;

heap *heap_new(size_t capacity, int (*cmp)(const void *a, const void *b));
bool heap_insert(heap *h, void *a);
bool heap_peek(heap *h, void **out);
void heap_remove(heap *h, void **out);
bool heap_change_key(heap *h, size_t idx, void *val);
void heap_free(heap *h);
void print_heap(heap *h);
