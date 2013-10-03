/*
    Samantha Oxley
    Lab 04: String manipulation when reading from standard in
    September 2013
*/
#include <iostream>
#include <string>
using namespace std;

int count_underscores(string);

int main(){
    string input;
    string name;
    string address;
    string city;
    string state;
    string zip;
    string citystatezip;
    string data [5];


    cout << "Enter a string: ";
    std::getline(cin, input);
    cout << "Original string <" << input << ">" << endl;
    int numCommas = count_underscores(input);
    if(numCommas == 4){
        for(int i=0; i<=numCommas; i++){
            data[i] = input.substr(0, input.find(','));
            input.erase(0, input.find(',')+1);
        }
        name = data[0];
        address = data[1];
        city = data[2];
        state = data[3];
        zip = data[4];
        citystatezip = city + ", " + state + " " + zip;
        cout << name << "\n" << address << "\n" << citystatezip << endl;
        if(!(zip.length() == 5 || zip.length() == 10)){
            cout << "Zip code is invalid.";
        }else{
            cout << "Zip code is valid.";
        }
    }else{
        cout << "Error: Incorrect format!" << endl;
    }
}

int count_underscores(string s){
    int counter = 0;
    for(int i=0; i < s.size(); i++){
        if(s[i] == ',') counter++;
    }
    return counter;
}
