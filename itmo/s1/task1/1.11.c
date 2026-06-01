#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

int merge(int *a, int *tmp, int left, int mid, int right) {
  int i = left, j = mid + 1, k = left;
  int count = 0;

  while (i < mid + 1 && j <= right) {
    if (a[i] <= a[j]) {
      tmp[k++] = a[i++];
    } else {
      tmp[k++] = a[j++];
      count += mid - i + 1;
    }
  }

  while (i < mid + 1) {
    tmp[k++] = a[i++];
  }

  while (j <= right) {
    tmp[k++] = a[j++];
  }

  for (int x = left; x <= right; x++) {
    a[x] = tmp[x];
  }

  return count;
}

int merge_sort(int *a, int *k, int left, int right) {
  if (left >= right)
    return 0;

  int mid = left + (right - left) / 2;

  int count = 0;
  count += merge_sort(a, k, left, mid);
  count += merge_sort(a, k, mid + 1, right);

  return count + merge(a, k, left, mid, right);
}

int count_inversions(int *a, size_t len) {
  if (len < 2)
    return 0;

  int *tmp = malloc(sizeof(int) * len);
  if (tmp == NULL) {
    return -1;
  }

  int inversions = merge_sort(a, tmp, 0, len - 1);

  free(tmp);

  return inversions;
}

int main(void) {
  int a[] = {2, 4, 1, 3};
  int n = sizeof(a) / sizeof(a[0]);

  int result = count_inversions(a, n);

  printf("Number of inversions: %d\n", result);

  return 0;
}
