#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <fstream>
#include <algorithm>
#include <iterator>
#include <numeric>

/**
 * This function opens a file specified by the filename argument,
 * and counts the number of lines in said file
 */
int count_lines(const std::string &filename)
{
    std::ifstream in(filename);
    in.unsetf(std::ios_base::skipws);

    // We are creating an iterator over the input stream and
    // passing it to the count algorithm to count the number
    // of newline characters
    return std::count(
        std::istream_iterator<char>(in),
        std::istream_iterator<char>(),
        '\n');
}

/**
 * Given a list of files, this function returns a list of
 * line counts for each of them
 */
std::vector<int>
count_lines_in_files(const std::vector<std::string> &files)
{
    std::vector<int> results;

    for (const auto &file: files) {
        results.push_back(count_lines(file));
    }

    return results;
}

int sum_files(const std::vector<int>& line_counts)
{
    return std::accumulate(line_counts.begin(), line_counts.end(), 0);
}


int main(int argc, char *argv[])
{
    auto results = count_lines_in_files({"main.cpp", "Makefile"});
    int num_lines_overall = sum_files(results);

    std::cout << num_lines_overall << "line(s) overall\n";

    int i=1;
    for (auto result: results) {
        std::cout << result << " line(s) "<<i<<"\n";
        i++;
    }

    return 0;
}

