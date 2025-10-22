#include <stdio.h>
#include <ctype.h>

main()
{
    //declaring variables
    char text[1000];
    char *p;
    int vowels = 0;
    int digits = 0;
    int words = 0;
    int inWord = 0;
    
    //capturing input
    printf("Enter a line: \n");
    fgets(text, sizeof(text), stdin);
    //setting pointer
    p=text;

    //while loop to iterate through sentence
    while(*p != '\0')
    {

        //converts lower to upper
        if(islower(*p))
        {
            *p = toupper(*p);
        }

        //checks vowels
        if(*p=='A' || *p=='E' || *p=='I' || *p=='O' || *p=='U')
        {
            vowels++;
        }

        //checks digits
        if(*p=='0'||*p=='1'||*p=='2'||*p=='3'||*p=='4'||*p=='5'||*p=='6'||*p=='7'||*p=='8'||*p=='9')
        {
            digits++;
        }

        //checks if in word to increment word
        if(isalpha(*p)||isdigit(*p))
        {
            if(!inWord)
            {
                inWord=1;
                words++;
            }
        }
        else
        {
            inWord=0;
        }

        //moves to next pointer
        p++;
    }

    //output
    printf("Number of vowels: %d \n", vowels);
    printf("Number of digits: %d \n", digits);
    printf("Number of words: %d \n", words);
    printf("Sentence: %s", text);

    return 0;
}