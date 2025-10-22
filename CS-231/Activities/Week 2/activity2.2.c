#include<stdio.h>


//function to convert Fahrenheit to Celsius
void convert_celsius(double f)
{
    double celsius =(f-32)*5.0/9.0;
    printf("%.2f Fahrenheit is %.2f Celsius\n", f, celsius);
}

//function to convert celsius to fahrenheit
void convert_farenheit(double c)
{
    double fahrenheit = (c*9.0/5.0)+32;
    printf("%.2f Celsius is %.2f Fahrenheit\n", c, fahrenheit);
}

main()
{
    double input;
    int option;

    //gets input
    printf("Enter a float: \n");
    scanf("%lf", &input);

    printf("Enter 1 for F to C \n Enter 2 for C to F ");
    scanf("%d", &option);

    //array of function pointers
    void(*fun_array[2])(double) = {convert_celsius, convert_farenheit};

    //uses pointers to call functions
    if(option ==1)
    {
        fun_array[0](input);
    }
    else if(option ==2)
    {
        fun_array[1](input);
    }
    else
    {
        printf("wrong option");
    }

    return 0;
}
