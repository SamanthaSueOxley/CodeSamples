/* Samantha Oxley- prof: T.J. Borrelli
 * File: Box.cpp
 * Purpose: Implementation of Box class
 */

#include <iostream>
#include <iomanip>
#include <string>
#include "box.h"
using namespace std;

//------------------------------------------
//Name: Box
//Purpose: creates a default Box
//Parameters: none
//Returns: nothing
//------------------------------------------
Box::Box( ){
    height = 0.0;
    cout << "In default Box constructor" << endl;
}

//------------------------------------------
//Name: Box
//Purpose: creates a Box with length and width
//Parameters:
//  length - length of Box
//  width - width of Box
//Returns: nothing
//------------------------------------------
Box::Box(double length, double width, double height) : Rectangle(length, width){
     //assigns length and width to private data members
     if (height > 0.0){  //valid dimensions
         this->height = height;
     }else{                //invalid dimensions
        this->height = 0.0;
     }
     cout << "In initializing Box constructor" << endl;
}


//------------------------------------------
//Name: ~Box
//Purpose: destruct Box
//Parameters: none
//Returns: nothing
//------------------------------------------
Box::~Box( ){
    cout << "In Box destructor with length of "
         << Rectangle::getLength() << endl;
}
//------------------------------------------
//Name: getHeight
//Purpose: gets width of Box
//Parameters: none
//Returns: height of Box
//------------------------------------------
double Box::getHeight() const{
    return height;
}

//------------------------------------------
//Name: calcArea
//Purpose: calculates area of Box
//Parameters: none
//Returns: area of Box (width x length)
//------------------------------------------
double Box::calcVolume() const{
     return Rectangle::calcArea() * height;
}

//------------------------------------------
//Name: print
//Purpose: print dimensions of Box
//Parameters: none
//Returns: none
//------------------------------------------
void Box::print( ) const{
    Rectangle::print();
    cout << "  Height: " << getHeight() << endl;
}
