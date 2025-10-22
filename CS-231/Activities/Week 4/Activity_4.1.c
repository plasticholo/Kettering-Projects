#include <stdio.h>
#include <math.h>

#define DISTANCE(x1,y1,x2,y2) sqrt(((x2)-(x1))*((x2)-(x1))+((y2)-(y1))*((y2)-(y1)))

main()
{
    double dist = DISTANCE(1,2,2,5);
   
    printf("Distance between the points (1,2) and (2,5): %.6f\n", dist);
    printf("Current Line Num: %d\n", __LINE__);
    printf("STDC Defined: %d\n", __STDC__);
    return 0;
}