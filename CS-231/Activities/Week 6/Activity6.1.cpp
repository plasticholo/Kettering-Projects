#include <iostream>
#include <vector>
#include <string>
using namespace std;

//class holding all the functions and private vars
class Name_age
{
private:
    vector<string> name;
    vector<double> age;
public:
    //function to read 
    void read_names()
    {
        cout << "Enter names (enter 'stop' to finish): " << endl;

        //while loop to collect all input
        while(true)
        {
            //creates variable to detect input
            string input;
            cout << "Name: ";
            getline(cin, input);

            //checks for stop command
            if (input == "stop")
            {
                break;
            }
            //enters input into the vector
            name.push_back(input);
        }
    }

    //function to read ages
    void read_ages()
    {
        cout << "Enter an age for each name:" << endl;
        
        //sets age for each name
        for(size_t i = 0; i<name.size(); i++)
        {
            double ageIn;

            //asks for and sets age
            cout << "Age for " << name[i] <<": ";
            cin >> ageIn;
            age.push_back(ageIn);
        }
    }

    //function to print each name
    void print()
    {
        cout << "\nName and Age: " << endl;

        //iterates through each name/age
        for(size_t i = 0; i< name.size(); i++)
        {
            cout << name[i] << ", " << age[i] << endl;
        }
    }
};

//main function
int main()
{
    Name_age manager;

    //calls each function with a manager
    manager.read_names();

    manager.read_ages();

    manager.print();

    return 0;
}