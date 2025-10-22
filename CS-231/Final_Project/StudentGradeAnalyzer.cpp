#include <map>
#include <vector>
#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <numeric>


using namespace std;

//----------------FUNCTION DECLERATIONS------------------------
//filterPassing: outputs the number of passing students
vector<pair<string,int>> filterPassing(const map<string, int>& students, int threshold)
{
    vector<pair<string, int>> passing;
    for(const auto& s : students)
    {
        if(s.second >= threshold)
        passing.push_back(s);
    }
    return passing;
}
//averageGrade: calculates the average grade of all the students
double averageGrade(const map<string, int>& students)
{
    int sum = 0;
    for(const auto& s : students)
    {
        sum+= s.second;
    }
    return static_cast<double>(sum) / students.size();
}
//maxGrade: finds the highest grade in the list
int maxGrade(const map<string, int>& students)
{
    auto it = max_element(students.begin(), students.end(), [](auto& a, auto& b) { return a.second < b.second;});
    return it->second;

}
//minGrade: finds the lowest grade in the list
int minGrade(const map<string, int>& students)
{
    auto it = min_element(students.begin(), students.end(),[](auto& a, auto& b) { return a.second < b.second;});
    return it->second;
}
//top_n: prints out the top n students and their grades
vector<pair<string, int>> top_n(const map<string, int>& students, size_t N)
{
    vector<pair<string, int>> sorted(students.begin(), students.end());
    sort(sorted.begin(), sorted.end(), [](auto& a, auto& b) { return a.second > b.second;});

    if(sorted.size() > N)
    {
        sorted.resize(N);
    }

    return sorted;
}


//-------------MAIN FUNCTION-------------------
int main(int argCount, char* argValue[])
{
    // declaring vars
    string filepath;
    int gradeThreshold;

    // checks and parses args
    if (argCount == 4 && string(argValue[2]) == "--pass")
    {
        filepath = argValue[1];
        gradeThreshold = stoi(argValue[3]);
    }
    else if (argCount == 2)
    {
        filepath = argValue[1];
        gradeThreshold = 70; // default threshold
    }
    else
    {
        cout << "Usage: " << argValue[0] << " <filepath> [--pass N]" << endl;
        return 1;
    }


    ifstream gradeBook(filepath);

    if(!gradeBook)
    {
        cout << "Error reading file";
        return 1;
    }

    //defines map
    map<string, int> students;
    string name;
    int grade;
    
    //puts the students and grades into a map
    while(gradeBook >> name >> grade)
    {
        students[name]= grade;
        
    }
    //flags if file is empty
    if(students.empty())
    {
        cout << "No students found in file." << endl;
        return 1;
    }

    //calls all functions
    auto passing = filterPassing(students, gradeThreshold);
    cout << "Total students: " << students.size() << endl;
    cout << "Passing Students: " << passing.size() << endl;
    cout << "Average Grade: " << averageGrade(students) << endl;
    cout << "Highest grade: " << maxGrade(students) << endl;
    cout << "Lowest grade: " << minGrade(students) << endl;
    cout << "Top 3 students: " << endl;
    
    //calls and prints out each student
    auto top3 = top_n(students, 3);
    for(const auto& s : top3)
    {
        cout << " " << s.first << "-" << s.second << endl;
    }

    return 0;
}