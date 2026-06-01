#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>

int sum_to(int sum, int *a, size_t m, int *b, size_t n, size_t *out_i,
           size_t *out_j) {
  if (m == 0 || n == 0)
    return -1;

  int i = 0, j = n - 1;
  bool found = false;
  while (i < m && j >= 0) {
    int s = a[i] + b[j];
    if (s == sum) {
      found = true;
      break;
    }
    if (s < sum) {
      i++;
      continue;
    }
    j--;
  }

  if (!found) {
    return -1;
  }

  *out_i = i;
  *out_j = j;

  return 0;
}

int main(void) {
  int a[] = {1, 4, 8, 13, 20};
  int b[] = {3, 7, 11, 17};

  size_t n = sizeof(a) / sizeof(a[0]);
  size_t m = sizeof(b) / sizeof(b[0]);

  size_t i, j;

  if (sum_to(22, a, n, b, m, &i, &j) == -1) {
    printf("Not possible to sum numbers.\n");
    return 0;
  }

  printf("i = %zu, j = %zu\n", i, j);
  printf("a[i] = %d, b[j] = %d\n", a[i], b[j]);

  return 0;
}
