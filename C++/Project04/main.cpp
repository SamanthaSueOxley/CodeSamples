#include <iostream>
#include "vehicle.h"
using namespace std;

void printVehicle(Vehicle& veh);
//bool operator==(Vehicle& veh#include <fstream>
#include "vehicle.h"
using namespace std;

int main()
{
    // attributes
    string fileName;
    int numVehicles;
    ifstream fin;

    // prompt for file name
    cout << "Program to read vehicle information from a file.\nEnter name of vehicle file to read: ";
    cin >> fileName;
    fin.open(fileName);
    if( !fin.is_open( ) ){
        cerr << "Unable to open file.";
        return 1;
    }
    fin >> numVehicles; //get number of vehicles
    Vehicle vehArray[numVehicles]; //set string array size to that number
    // populate string array
    for(int i=0; i < numVehicles; i++){
        Vehicle veh(fin);
        if(i > 1){
            for(int j=0; j < i-1; j++){
                if( veh == vehArray[j]){
                    cout << "Duplicate Vehicle detected ------ IGNORED" << endl;
                    Vehicle emptyVeh;
                    veh = emptyVeh;
                    break;
                }
            }
        }
        vehArray[i] = veh;
    }

    cout << "Vehicle List" << endl;
    for(int i=0; i < numVehicles; i++){
        printVehicle(vehArray[i]);
    }
    return 0;
}
void printVehicle( Vehicle& veh){
    veh.startAcc();
    cout << "-------------------"
        << "\nVin: " << veh.getIdNum()
        << "\nManufacturer: " << veh.getManufacturer()
        << "\nColor: " << veh.getColor()
        << "\nCost: " << veh.getCost()
        << "\nAccessory List: " << endl;
    while(veh.hasNextAcc()){
        cout << "\t" << veh.nextAcc() << endl;
    }
}
