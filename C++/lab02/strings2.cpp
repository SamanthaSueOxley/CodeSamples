/*
    Samantha Oxley
    Lab 04: String manipulation when reading from file
    September 2013
*/
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
using namespace std;

int count_underscores(string);

int main(){
    string inputFile;
    string currLine;
    string name;
    string address;
    string city;
    string state;
    string zip;
    string citystatezip;
    string data [5];
    ifstream fin; //create file object

    cout << "Enter an input file: "; //ask for filename
    cin >> inputFile;
    fin.open( inputFile.c_str() );
    if(fin.is_open()){
        while(!fin.eof()){
            getline(fin, currLine);
            cout << "Original string <" << currLine << ">" << "\n----------" << endl;
            int numCommas = count_underscores(currLine);
            if(numCommas == 4){
                for(int i=0; i<=numCommas; i++){
                    data[i] = currLine.substr(0, currLine.find(','));
                    currLine.erase(0, currLine.find(',')+1);
                }
                name = data[0];
                address = data[1];
                city = data[2];
                state = data[3];
                zip = data[4];
                citystatezip = city + ", " + state + " " + zip;
                cout << name << "\n" << address << "\n" << citystatezip << endl;
                if(!(zip.length() == 5 || zip.length() == 10)){
                    cout << "Zip code is invalid.\n\n";
                }else{
                    cout << "Zip code is valid.\n\n";
                }
            }else{
                cout << "Error: Incorrect format!" << endl;
            }
        }
    }else{
        cout << "Unable to open file name " << inputFile;
        return 1;
    }
}

int count_underscores(string s){
    int counter = 0;
    for(int i=0; i < s.size(); i++){
        if(s[i] == ',') counter++;
    }
    return counter;
}

