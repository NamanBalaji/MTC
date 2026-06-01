#include <limits.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

int find_min_diff_pair(int *a, size_t n, int *b, size_t m, size_t *out_i,
                       size_t *out_j) {
  if (n == 0 || m == 0)
    return -1;

  size_t i = 0, j = 0;

  int best_diff = INT_MAX;
  int best_i = 0, bes_j = 0;

  while (i < n && j < m) {
    int diff = abs(a[i] - b[j]);
    if (diff < best_diff) {
      best_i = i;
      bes_j = j;
    }

    if (best_diff == 0)
      break;

    if (a[i] < b[j]) {
      i++;
      continue;
    }

    j++;
  }

  *out_i = best_i;
  *out_j = bes_j;

  return 0;
}

int main(void) {
  int a[] = {1, 4, 8, 13, 20};
  int b[] = {3, 7, 11, 17};

  size_t n = sizeof(a) / sizeof(a[0]);
  size_t m = sizeof(b) / sizeof(b[0]);

  size_t i, j;

  if (find_min_diff_pair(a, n, b, m, &i, &j) == -1) {
    printf("One of the arrays is empty\n");
    return 0;
  }

  printf("i = %zu, j = %zu\n", i, j);
  printf("a[i] = %d, b[j] = %d\n", a[i], b[j]);
  printf("minimum difference = %lld\n",
         llabs((long long)a[i] - (long long)b[j]));

  return 0;
}
