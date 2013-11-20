/* Samantha Oxley - prof: T.J. Borrelli
 * testBox.cpp
 * Purpose:  test Box class
 */

#include <iostream>
#include <string>
#include <iomanip>
#include "box.h"
using namespace std;

int main (){
    {
        //print options
        cout << fixed << showpoint << setprecision(2);

        //create a default Box
        Box box0;
        box0.print( );
        cout << "Area of Box is "
             << box0.calcArea() << endl;
        cout << endl;

        //create a Box of 10.5 x 20.25
        Box box(10.5, 20.25, 7.80);

        //print results
        box.print( );
        cout << "Volume of Box is "
             << box.calcVolume() << endl;
        cout << endl;
    }
    return 0;
} //end main
