#include <stdio.h>
#include <stdlib.h>

void merge(int *a, int *tmp, int left, int mid, int right) {
  int i = left, j = mid + 1, k = left;
  while (i < mid + 1 || j <= right) {
    if (j > right || (i < mid + 1 && a[i] < a[j])) {
      tmp[k++] = a[i++];
    } else {
      tmp[k++] = a[j++];
    }
  }

  for (int x = left; x <= right; x++)
    a[x] = tmp[x];
}

int merge_sort(int *a, int len) {
  if (len < 2) {
    return 0;
  }

  int *tmp = malloc(sizeof(int) * len);
  if (tmp == NULL) {
    return -1;
  }

  for (int width = 1; width < len; width *= 2) {
    for (int left = 0; left < len; left += 2 * width) {
      int mid = left + width < len ? left + width : len;
      int right = left + 2 * width < len ? left + 2 * width : len;

      merge(a, tmp, left, mid, right);
    }
  }

  free(tmp);
  return 0;
}

int main(void) {
  int a[] = {12, 4, 9, 34, 2, 8, 6, 10, 5, 7, 17, 24, 50};
  int n = sizeof(a) / sizeof(a[0]);

  int ok = merge_sort(a, n);
  if (ok == -1) {
    printf("Memory allocation failed\n");
    return 1;
  }

  for (int i = 0; i < n; i++) {
    printf("%d ", a[i]);
  }

  printf("\n");
  return 0;
}
