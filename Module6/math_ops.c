#include <stdio.h>

void print_math(int a, int b)
{
    int sum = a + b;
    int product = a * b;

    printf("Sum: %d\n", sum);
    printf("Product: %d\n", product);
}

int main(void)
{
    int a, b;

    printf("Enter first number: ");
    scanf("%d", &a);

    printf("Enter second number: ");
    scanf("%d", &b);

    print_math(a, b);
    return 0;
}
