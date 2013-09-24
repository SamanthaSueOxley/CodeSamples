/*
    Samantha Oxley
    ISTE-202
    Project 1: converting binary integers to decimal
*/
#include <iostream>
#include <iomanip>
using namespace std;

int main(){
    double starting;
    double ending;
    double stepSize;
    double current;
    double calc;

    do{
        cout << "Enter the starting temperature in F: ";
        cin >> starting;
    }while(starting < -459.67);
    cout << "Enter the ending value: ";
    cin >> ending;

    do{
        cout << "Enter the step-size: ";
        cin >> stepSize;
    }while(stepSize < 0);
    current = starting;

    do{
        calc = (( current - 32) * .555555555556);
        cout << setprecision(3) << setw(10) << fixed << current << " degreees F in celsius is: " << setprecision(3) << fixed << setw(10) << calc << endl;
        current += stepSize;
    }while(current < ending);

}

