#include <stddef.h>
#include <stdio.h>

int count_greater_pairs(int *a, size_t m, int *b, size_t n) {
  if (m == 0 || n == 0)
    return 0;

  size_t i = 0, j = 0;
  int pairs = 0;

  while (i < m && j < n) {
    if (a[i] <= b[j]) {
      i++;
      continue;
    }

    pairs += n - i;
    j++;
  }

  return pairs;
}

int main(void) {
  int a[] = {2, 4, 6};
  int b[] = {1, 3, 5};

  size_t n = sizeof(a) / sizeof(a[0]);
  size_t m = sizeof(b) / sizeof(b[0]);

  int result = count_greater_pairs(a, n, b, m);

  printf("Number of pairs: %d\n", result);

  return 0;
}
