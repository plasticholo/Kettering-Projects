#include <stdio.h>

main()
{
    printf("Size of short: %lu bits\n", sizeof(short)*8);
    printf("Size of int: %lu bits\n", sizeof(int)*8);
    printf("Size of unsigned int: %lu bits\n", sizeof(unsigned int)*8);
    printf("Size of long: %lu bits\n", sizeof(long)*8);
    printf("Size of unsigned long: %lu bits\n", sizeof(unsigned long)*8);
    printf("Size of float: %lu bits\n", sizeof(float)*8);
    printf("Size of double: %lu bits\n", sizeof(double)*8);

    //declaring variable for user input
    int input;

    //asks for int from user
    printf("Enter an integer \n");
    scanf("%d", &input);

    //prints out the value in hexadecimal and octal
    printf("Hex: %x\n", input);
    printf("Oct: %o\n", input);

    //declaring bit variable
    int bit;

    //asking for the bit they want to change
    printf("Enter the bit you want to change (0-31)");
    scanf("%d", &bit);

    //modifies the original int
    int toggled = input ^ (1<<bit);
    int setZero = input & ~(1<<bit);
    int setOne = input | (1<<bit);

    //prints results
    printf("Original Number: %d\n", input);
    printf("Toggled: %d\n", toggled);
    printf("Bit set to zero: %d\n", setZero);
    printf("Bit set to one: %d\n", setOne);

    return 0;
}