
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

#include "person2.h"

using namespace std;

classroom addStudent(classroom classR,name_age student){

	//use add_name_age from the classroom object
	classR.add_name_age(student.name(), student.age());
	return classR;

}


int main(int argc, char *argv[])
{
	string className = "CS 231";
	classroom myClass(className);

	vector<name_age> students
	{{ "Juan",35},
    { "Jane",50},
    { "Martha",25},
    { "Tijani",20}};

	//vector<int> ages {1,2,3,4};

	myClass = accumulate(students.cbegin(),students.cend(),myClass,addStudent);

	myClass.print_names_ages();

    return 0;
}
