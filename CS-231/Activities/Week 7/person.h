#ifndef PERSON_H
#define PERSON_H

#include <string>
#include <ostream>

class person_t {
public:
    enum class_t {
        freshman,
        sophomore,
		junior,
		senior,
        masters,
		doctoral,
		other
    };

    enum output_format_t {
        name_only,
        full_name
    };

    person_t(): m_name("Chris"), m_surname("Doe"), m_class(other) {}

    person_t(std::string name, class_t cls, int age = 0)
        : m_name(name)
        , m_surname("Doe")
        , m_class(cls)
        , m_age(age)
    {
    }

    person_t(std::string name, class_t cls, int age = 0, std::string major="")
           : m_name(name)
           , m_surname("Doe")
           , m_class(cls)
           , m_age(age)
    	   , m_major(major)
       {
       }


    person_t(std::string name, const std::string &surname, class_t cls, int age = 0)
        : m_name(name)
        , m_surname(surname)
        , m_class(cls)
        , m_age(age)
    {
    }

    std::string name() const
    {
        return m_name;
    }

    std::string surname() const
    {
        return m_surname;
    }

    class_t cls() const
    {
        return m_class;
    }

    int age() const
    {
        return m_age;
    }

    std::string major() const
     {
         return m_major;
     }


    void print(std::ostream &out,
               person_t::output_format_t format) const
    {
        if (format == person_t::name_only) {
            out << name() << '\n';

        } else if (format == person_t::full_name) {
            out << name() << ' '
                << surname() << '\n';

        }
    }

private:
    std::string m_name;
    std::string m_surname;
    class_t m_class;
    std::string m_major;
    int m_age;
};

#endif // PERSON_H
