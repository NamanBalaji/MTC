#include <stddef.h>
#include <stdio.h>

int count_equal_pairs(int *a, size_t n, int *b, size_t m) {
  if (n == 0 || m == 0) {
    return 0;
  }

  size_t i = 0, j = 0;
  int pair_count = 0;

  while (i < n && j < m) {
    if (a[i] < b[j]) {
      i++;
      continue;
    }

    if (b[j] < a[i]) {
      j++;
      continue;
    }

    int val = a[i];
    int count_a = 0, count_b = 0;

    while (i < n && a[i] == val) {
      i++;
      count_a++;
    }

    while (j < m && b[j] == val) {
      j++;
      count_b++;
    }

    pair_count += count_a * count_b;
  }

  return pair_count;
}

int main(void) {
  int a[] = {1, 2, 2, 2, 5};
  int b[] = {2, 2, 4, 5};

  size_t n = sizeof(a) / sizeof(a[0]);
  size_t m = sizeof(b) / sizeof(b[0]);

  int result = count_equal_pairs(a, n, b, m);

  printf("Number of pairs: %d\n", result);
}
