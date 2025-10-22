#include <stdio.h>
#include <stdlib.h>

//Student structure
typedef struct
{
    int id;
    char name[50];
    float gpa;
} Student;

//Void function to write to a text file
void writeTextFile()
{
    //opens file
    FILE *file = fopen("students.txt", "w");

    //Makes sure file actually opens
    if(file==NULL)
    {
        printf("Error opening file! \n");
        return;
    }

    //structure containing text to write to file
    Student students[4] = 
    {
        {201, "Emily Carter", 3.75},
        {202, "Jason Lee", 3.60},
        {203, "Sophia Martinez", 3.90},
        {204, "Daniel Thompson", 3.85}
    };

    //iterates through structure to write to file
    for(int i=0; i<4; i++)
    {
        fprintf(file, "%d, %s, %f, \n", students[i].id, students[i].name, students[i].gpa);
    }

    //closes file
    fclose(file);
    printf("Successfully written to text file \n");
}

//void functino to read txt file
void readTextFile()
{
    //opens file
    FILE *file = fopen("students.txt", "r");

    //makes sure file is properly opened
    if(file==NULL)
    {
        printf("Error opening file! \n");
        return;
    }

    Student student;
    printf("Students from text file:\n");
    printf("ID\tName\t\t\tGPA\n");
    printf("-----------------------------------------\n");

    //reads each line
    while(fscanf(file, "%d, %49[^,], %f", &student.id, student.name, &student.gpa) == 3)
    {
        //removes potential trailing space from name
        char *end = student.name + strlen(student.name) - 1;
        if(*end == ' ') *end = '\0';
        
        printf("%d\t%s\t\t%.2f\n", student.id, student.name, student.gpa);
        
        //skips to next line
        while(fgetc(file) != '\n' && !feof(file));
    }

    //closes file
    fclose(file);
}

//function to write to a binary file
void writeBinaryFile()
{
    //opens file
    FILE *file = fopen("students.bin", "wb");
    
    //checks to make sure file actually opens
    if(file == NULL)
    {
        printf("Error Opening File! \n");
        return;
    }

    //creates struct with info
    Student students[4] = 
    {
        {201, "Emily Carter", 3.75},
        {202, "Jason Lee", 3.60},
        {203, "Sophia Martinez", 3.90},
        {204, "Daniel Thompson", 3.85}
    };

    //writes to file
    fwrite(students, sizeof(Student), 4, file);

    //closes file
    fclose(file);
    printf("Succesfully Writen to binary file \n");
}

//function to read a binary file
void readBinaryFile()
{
    //opens file
    FILE *file = fopen("students.bin", "rb");
    
    //checks to make sure file actually opens
    if(file == NULL)
    {
        printf("Error Opening File! \n");
        return;
    }
    
    Student student;
    printf("Students from binary file:\n");
    printf("ID\tName\t\t\tGPA\n");
    printf("-----------------------------------------\n");

    //loop to print data to terminal
    while(fread(&student, sizeof(Student), 1, file)==1)
    {
        printf("%d\t%s\t\t%.2f\n", student.id, student.name, student.gpa);
    }

    //closes file
    fclose(file);
}

main()
{
    //text file functions
    writeTextFile();
    readTextFile();

    //prints newline for readability
    printf("\n");

    //binary file functions
    writeBinaryFile();
    readBinaryFile();
    
    return 0;
}