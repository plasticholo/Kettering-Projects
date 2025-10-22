#include <stdio.h>

main()
{
    //declaring variables
    float fahrenheit;
    float celsius;
    char dayoftheweek[7];
    int day;
    int month;
    int year;
    float uppertemp = 134;
    float lowertemp = -128.6;

    //asks user for day of the week as well as the date and temp
    printf("Enter the day of the week: \n");
    scanf("%s", &dayoftheweek);
    printf("Enter the day (In an integer): \n");
    scanf("%d", &day);
    printf("Enter the month (In an integer): \n");
    scanf("%d", &month);
    printf("Enter the year (In an integer): \n");
    scanf("%d", &year);
    printf("Enter the temperature (In fahrenheit): \n");
    scanf("%f", &fahrenheit);

    //prints all entered information
    printf("It is: %s \n", dayoftheweek);
    printf("The day is: %d \n", day);
    printf("The month is: %d \n", month);
    printf("The year is: %d \n", year);
    printf("It is: %f F \n", fahrenheit);
    
    //calculates and prints celsius
    celsius = (5.0/9.0)*(fahrenheit-32.0);
    printf("It is: %f C", celsius);

    //checks to see if the temp is a naturally occuring one
    if(fahrenheit>uppertemp||fahrenheit<lowertemp)
    {
        printf("Those aren't Earth Temps \n");
    }
    else
    {
        printf("Those are Earth Temps \n");
    }
    
    return 0;
}