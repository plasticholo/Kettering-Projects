
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

#include "./person.h"

using namespace std;

string name(const person_t &person)
{
    return person.name();
}

//helper function that returns true if age in person_t object is less than 30
bool is_under30(const person_t & person){

}

//helper function that returns true if major in person_t object is CS
bool is_CS(const person_t & person){

}

//helper function that returns true if person_t object is a freshman
bool is_Freshman(const person_t & person){

}

//helper function to return the name and age of a person_t object
std::string name_and_age(const person_t & person){

}

int main(int argc, char *argv[])
{
	//add code to person.h to add the Major as one
	//of the attributes in the person_t class
    vector<person_t> people {
        { "Juan"  , person_t::freshman, 27,"CS" },
        { "Jane"   , person_t::sophomore, 50,"ME" },
        { "Martha" , person_t::junior, 25,"CS" },
        { "Tijani"  , person_t::senior, 20,"EE"   },
        { "Rose"   , person_t::junior, 25,"CS" },
        { "Tom"    , person_t::doctoral, 70,"CS"  },
        { "Rick"    , person_t::freshman, 29,"CS"  }
    };


    std::vector<person_t> freshman;
    std::vector<person_t> under_30;
    std::vector<person_t> major_cs;

    //filter for persons that are freshman (use copy_if)



    //find those who are under 30
    std::copy_if(freshman.cbegin(), freshman.cend(),
                 std::back_inserter(under_30),
                   is_under30);
    
    //add code here to keep people whose major is CS



    std::vector<std::string> names(major_cs.size());
    //grab the name and age of each person using transform
    //with the name and age helper function


    //change this to print out their name AND age
    for (const auto& name: names) {
        std::cout << name << '\n';
    }

    return 0;
}
