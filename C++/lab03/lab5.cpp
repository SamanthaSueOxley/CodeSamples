/*
    Samantha Oxley
    ISTE 202 - Lab 05
    Structs & File I/O
    simple setting/printing of struct data to output and then appended to file
*/
#include <iostream>
#include <iomanip>
#include <fstream>
using namespace std;

struct Commission{
    int idNum;
    double base;
    double sales;
    double rate;
};

void structSet(Commission&);
void structPrint(Commission);

int main(){
    Commission comm;
    ofstream fout;
    string filename;

    structSet(comm);
    structPrint(comm);

    do{
        cout << "Enter a filename to record user information:";
        cin >> filename;
        fout.open(filename.c_str(), ios::app);
    }while( !fout.is_open() );
    fout << "idNum:" << setw(10) << comm.idNum << endl;
    fout << "base:" << setw(10) << comm.base << endl;
    fout << "sales:" << setw(10) << comm.sales << endl;
    fout << "rate:" << setw(10) << comm.rate << endl;


}
void structSet(Commission& comm){
    cout << "Please enter identification number:";
    cin >> comm.idNum;
    cout << "Please enter base salary:";
    cin >> comm.base;
    cout << "Please enter sales amount for period:";
    cin >> comm.sales;
    cout << "Please enter commission rate(as fraction):";
    cin >> comm.rate;
    cin.ignore(1000, '\n');  //flushhhhh
}
void structPrint(Commission comm){
    cout << "idNum:" << setw(10) << comm.idNum << endl;
    cout << "base:" << setw(10) << comm.base << endl;
    cout << "sales:" << setw(10) << comm.sales << endl;
    cout << "rate:" << setw(10) << comm.rate << endl;
}
