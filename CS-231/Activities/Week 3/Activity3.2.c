#include <stdio.h>

//structure to hold data
struct daily_temp
{
    //declaring vars
    float fahr;
    float celsius;
    int earth_temps;
};

//function to check temp range
int earth_temps_check(float celsius)
{
    //checks temperature range
    if(celsius >= -100.0 && celsius <= 60.0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

//function to convert to celsius
float convert_celsius(double f)
{
    double celsius =(f-32)*5.0/9.0;
    return celsius;
}

main()
{
    //initializes structure
    struct daily_temp week[7];
    
    //declaring array for days
    const char *day_names[] =
    {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    //iterates through to gather input
    for(int i=0; i<7;i++)
    {
        //gets input for each day
        printf("Enter the temp in Fahrenheit for %s: ", day_names[i]);
        scanf("%f", &week[i].fahr);

        //convert to celsius
        week[i].celsius = convert_celsius(week[i].fahr);

        //check temp
        week[i].earth_temps = earth_temps_check(week[i].celsius);
    }

    //outputs results
    for(int i=0; i<7;i++)
    {
        printf("Day: %s \n", day_names[i]);
        printf("Fahrenheit: %f \n", week[i].fahr);
        printf("Celsius: %f \n", week[i].celsius);

        if(week[i].earth_temps==1)
        {
            printf("Valid Earth temp \n \n");
        }
        else
        {
            printf("Not a valid Earth temp \n \n");
        }
    }
}