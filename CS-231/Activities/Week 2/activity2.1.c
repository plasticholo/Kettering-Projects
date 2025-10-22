#include <stdio.h>

main()
{
    //declaring variables
    int num1;
    int num2;
    char oper;
    int finalnum;
    int bool = 1;
    char yn;

    while(bool==1)
    {
        //getting input
        printf("Enter your first number: \n");
        scanf("%d", &num1);
        printf("Enter your second number: \n");
        scanf("%d", &num2);

        getchar();
        printf("Enter the operand: \n");
        scanf("%c", &oper);
        
        //switch case for different operands
        switch(oper)
        {
        case '*':
        case 'm':
        case 'M':
            finalnum = (num1*num2);
            break;
        case '/':
        case 'd':
        case 'D':
            finalnum = (num1/num2);
            break;
        case '-':
        case 's':
        case 'S':
            finalnum = (num1-num2);
            break;
        case '+':
        case 'p':
        case 'P':
            finalnum = (num1+num2);
            break;
                
        default:
            printf("Not a defined operand \n");
            break;
        }

        //prints the final num and asks if they want to continue
        printf("The final answer is: %d\n", finalnum);
        printf("Would you like to continue? (y/n): \n");
        getchar();
        scanf("%c", &yn);

        //checks response
        if(yn=='y' || yn=='Y')
        {
            //continues
            printf("Continuing... \n\n");
        }
        else if (yn='n' || yn=='N')
        {
            //quits
            printf("Quitting... \n");
            bool = 0;
        }
        else
        {
            printf("Invalid input, quitting...");
            bool=0;
        }
    }

    return 0;
}