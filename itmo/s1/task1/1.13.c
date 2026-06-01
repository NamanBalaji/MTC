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

void sort(int *a, int *k, int left, int right) {
  if (left >= right) {
    return;
  }

  int mid = left + (right - left) / 2;
  sort(a, k, left, mid);
  sort(a, k, mid + 1, right);

  merge(a, k, left, mid, right);
}

int merge_sort(int *a, int len) {
  if (len < 2) {
    return 0;
  }

  int *k = malloc(sizeof(int) * len);
  if (k == NULL) {
    return -1;
  }

  sort(a, k, 0, len - 1);

  free(k);
  return 0;
}

int main(void) {
  int a[] = {12, 4, 9, 34, 2, 8, 6, 10, 5, 7, 17, 24, 50};

  int ok = merge_sort(a, 13);
  if (ok == -1) {
    printf("An error occurred while sorting \n");
    return 1;
  };

  for (int i = 0; i < 13; i++)
    printf("%d ", a[i]);

  printf("\n");
}
