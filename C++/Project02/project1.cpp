/*
    Samantha Oxley - 10/07/2013
    C++ - ISTE 202
    Project 02: password validation
*/
#include <iostream>
#include <fstream>
using namespace std;

string checkLengthUpperLower(string);
string checkDigitsSpecial(string);
string checkFirstChar(string);

int main(){
    string pswd;
    string pswdFile;
    ifstream fin;

    cout << "Enter password file: "; //prompt for file to open for list of passwords separated by new line characters
    getline(cin, pswdFile);
    fin.open(pswdFile.c_str());
    if(!fin.is_open()){ //check if file is unopened, exit with message
        cerr << "File will not open." << endl;
        return 1;
    }
    while(!fin.eof()){ //read in each password and test it
        getline(fin, pswd);
        string lengthUpperLower = checkLengthUpperLower(pswd);
        string digitsSpecial = checkDigitsSpecial(pswd);
        string firstChar = checkFirstChar(pswd);

        cout << "Proposed password: " << pswd << endl;
        cout << lengthUpperLower << digitsSpecial << firstChar;
        if((lengthUpperLower.length() > 0) || (digitsSpecial.length() > 0) || (firstChar.length() > 0)){
            cout << "Password is invalid\n" << endl;
        }else{
            cout << "Password is valid\n" << endl;
        }
    }

}
/*
    Validates string length, upper case/lower case presence
    Parameters: string of password to be validated
*/
string checkLengthUpperLower(string pswd){
    string returnString;
    int countLower = 0;
    int countUpper = 0;
    if(pswd.length() < 8){
        returnString += "\tError - length must be at least 8\n";
    }else if(pswd.length() > 15){
        returnString += "\tError - length must be no more than 15\n";
    }//length validation
    for(int i=0; i < pswd.length(); i++){
        if(pswd.at(i) >= 'a' && pswd.at(i) <= 'z'){ countLower++; }
    }
    if(countLower == 0){
        returnString += "\tMust have at least one lower case letter\n";
    }//lower case validation
    for(int j=0; j < pswd.length(); j++){
        if(pswd.at(j) >= 'A' && pswd.at(j) <= 'Z'){ countUpper++; }
    }
    if(countUpper == 0){
        returnString += "\tMust have at least one upper case letter\n";
    }//upper case validation
    return returnString;
}
/*
    Validates string's digits occurrence and checks for special characters
    Parameters: string of password to be validated
*/
string checkDigitsSpecial(string pswd){
    string returnString;
    int countDigits = 0;
    for(int k=0; k < pswd.length(); k++){
        if(pswd.at(k) >= '0' && pswd.at(k) <= '9'){
            countDigits++;
        }
    }//digit validation
    if(countDigits < 2){
        returnString += "\tMust have at least two digits\n";
    }
    for(int l=0; l < pswd.length(); l++){
        if((pswd.at(l) <= '/') || (pswd.at(l) >= ':' && pswd.at(l) <= '@') || (pswd.at(l) >= '[' && pswd.at(l) <= '`') || (pswd.at(l) >= '{')){
            returnString += "\tMust not have any special characters\n";
            break;
        }
    }//check for special characters
    return returnString;
}
/*
    Checks the first character to be a letter
    Parameters: string of password to be validated
*/
string checkFirstChar(string pswd){
    string returnString;
    if(!((pswd.at(0) >= 'A' && pswd.at(0) <= 'Z') || (pswd.at(0) >= 'a' && pswd.at(0) <= 'z'))){
        returnString += "\tMust start with a letter\n";
    }//check for letter first character
    return returnString;
}
