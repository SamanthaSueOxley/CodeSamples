/*
    Samantha Oxley
    ISTE-202
    Project 1: converting binary integers to decimal
*/
#include <iostream>
using namespace std;

int main(){
    int go = 1;
    int value;
    int decimal = 0;
    int mult = 1;

    while(go){
        mult = 1;
        decimal = 0;
        cout << "Enter a binary integer - 0 to quit:";
        cin >> value;
        if(value == 0){
            go = 0;
        }
        while(value >= 1){
            if((value%10 == 1) || value%10 == 0){
                if( (value % 2) == 1 ){
                    decimal += (1 * mult);
                    value--;
                }
                value /= 10;
                mult *= 2;
            }else{
                cout << "Invalid!" << endl;
                value = -1;
            }
        }
        cout << "converted to decimal is: " << decimal << endl;
    }//end if 0
}
