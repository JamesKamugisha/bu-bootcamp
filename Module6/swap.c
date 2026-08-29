#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    // This function receives copies of the original values, not their addresses.
}

int main(void) {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x, y);

    x = 10;
    y = 20;
    broken_swap(x, y);
    printf("After broken_swap: x = %d, y = %d\n", x, y);

    return 0;
}
