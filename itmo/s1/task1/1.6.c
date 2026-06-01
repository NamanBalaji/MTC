#include <stdio.h>

int find_common_num(int *arr1, size_t n, int *arr2, size_t m) {
  size_t i = 0, j = 0;

  while (i < n && j < m) {
    if (arr1[i] == arr2[j])
      return (int)i;

    if (arr1[i] < arr2[j])
      i++;
    else
      j++;
  }

  return -1;
}

int main(void) {
  int arr1[] = {0, 2, 4, 6, 13};
  int arr2[] = {1, 3, 5, 7, 9, 11, 13};

  size_t n = sizeof(arr1) / sizeof(arr1[0]);
  size_t m = sizeof(arr2) / sizeof(arr2[0]);

  int idx = find_common_num(arr1, n, arr2, m);

  if (idx == -1) {
    printf("No common element found\n");
    return 0;
  }

  printf("Found common element %d\n", arr1[idx]);
}
