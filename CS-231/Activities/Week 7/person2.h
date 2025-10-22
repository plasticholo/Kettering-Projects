#ifndef PERSON_H
#define PERSON_H

#include <string>
#include <vector>
#include <iostream>

using namespace std;

class classroom{
	private:
		string classname;
    	vector<string> names;
    	vector<int> ages;

    //set the classroom in the constructor
	public:
    	 classroom(string className)
    	        : classname(className)
    	 {}

    	//add name to names vector and age to ages vector
    	void add_name_age(string name,int age){
			names.push_back(name);
			ages.push_back(age);
    	}

    	void print_names_ages(){

    		cout<<classname<<endl;
    		cout<<"---------------------------"<<endl;
    		for (int i=0; i<names.size(); i++){
    			cout<<names[i]<<" "<<ages[i]<<endl;
    		}
    	}
};



class name_age {
public:


    name_age()
        : m_name("John")
        , m_age(20)
    {
    }


    name_age(string name, int age)
        : m_name(name)
        , m_age(age)
    {
    }

    //write a getter name() for name
	string name() const
	{
		return m_name;
	}


    //write a getter age() for age
	int age() const
	{
		return m_age;
	}


private:
    string m_name;
    int m_age;
};

#endif // PERSON_H
