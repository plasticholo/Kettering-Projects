#include <iostream>
#include <map>
#include <string>
#include <typeinfo>
#include <vector>
#include <algorithm>

using namespace std; 
/*
    All the functions except displayGrades are pure because they all produce the same output given the same input
    they also do not have any "side effects" or modify the external state

    If we modified the scores vector the functions would be mutable instead of immuatable. Additionally this would
    make the functions impure

    displayGrades is impure because if given the same input(in this case the gradebook) it would not always produce
    the same ouput. This is because if it is displaying the same gradebook two different times the contents within
    may have changed therefore creating a different output.

*/

template<typename K, typename V>
class Gradebook
{
    private:
        map<K,V> grades;

    public:
    
    void addStudent(K key, V value)
    {
        grades[key] = value;  
        cout << "Added student " << key << " with grade: " << value << endl;  
    }

    void updateGrade(K key, V value)
    {
        auto it = grades.find(key);  
        
        if(it != grades.end())
        {
            it->second = value;
            cout << "Updated grade for " << key << " to " << value << endl;
        }
        else
        {
            cout << "Student not found"<< endl;
        }
    }

    void displayGrades()
    {
        cout << "Student Grades:" << endl;

        if(grades.empty())
        {
            cout << "No students" << endl;  
            return;
        }

        for(const auto& pair : grades)
        {
            cout << pair.first << " -> " << pair.second << endl;
        }
    }

    
    vector<V> scaleGrades(double factor = 1.1)
    {
        vector<V> allGrades;
        vector<V> scaledGrades;
        
        for(const auto& pair : grades)
        {
            allGrades.push_back(pair.second);
        }
        
        scaledGrades.resize(allGrades.size());
        
        transform(allGrades.begin(), allGrades.end(), scaledGrades.begin(),
                 [factor](V grade) { return grade * factor; });
        
        return scaledGrades;
    }
    
    pair<vector<V>, vector<V>> divideByGrades(V passLimit = 70)
    {
        vector<V> allGrades;
        vector<V> passing;
        vector<V> failing;
        
        for(const auto& pair : grades)
        {
            allGrades.push_back(pair.second);
        }
        
        copy_if(allGrades.begin(), allGrades.end(), back_inserter(passing),
               [passLimit](V grade) { return grade >= passLimit; });
        
        copy_if(allGrades.begin(), allGrades.end(), back_inserter(failing),
               [passLimit](V grade) { return grade < passLimit; });
        
        return make_pair(passing, failing);
    }
};

main() 
{
    cout << "Student name gradebook:" << endl;

    Gradebook<string, int> nameGradeBook;  

    nameGradeBook.addStudent("Alice", 85);
    nameGradeBook.addStudent("Bob", 92);
    nameGradeBook.addStudent("Charlie", 78);
    nameGradeBook.displayGrades();
    nameGradeBook.updateGrade("Alice", 90);
    nameGradeBook.displayGrades();

    cout << endl;
    cout << "Student ID gradebook:" << endl;

    Gradebook<int, int> idGradeBook;  

    idGradeBook.addStudent(101,88);
    idGradeBook.addStudent(102,95);
    idGradeBook.addStudent(103,73);
    idGradeBook.displayGrades();
    idGradeBook.updateGrade(102,97);  
    idGradeBook.displayGrades();

    cout << "\nID book scaled grades (115%):" << endl;
    vector<int> idScaled = idGradeBook.scaleGrades(1.15);
    for(size_t i = 0; i < idScaled.size(); i++)
    {
        cout << idScaled[i] << " ";
    }
    cout << endl;

    cout << "\nID book passing/failing:" << endl;
    auto idDivided = idGradeBook.divideByGrades();
    cout << "Passing: ";
    for(size_t i = 0; i < idDivided.first.size(); i++)
    {
        cout << idDivided.first[i] << " ";
    }
    cout << endl;
    
    cout << "Failing: ";
    for(size_t i = 0; i < idDivided.second.size(); i++)
    {
        cout << idDivided.second[i] << " ";
    }
    cout << endl;

    return 0;
}