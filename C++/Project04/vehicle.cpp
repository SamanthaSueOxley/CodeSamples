/*
    Samantha Oxley
    Proj04 - 11/13/13
    Vehicle class,
*/
#include "vehicle.h"
//using namespace std;

Vehicle::Vehicle(){
    idNum = 999;
    manufacturer = "";
    color = "";
    cost = 0.00;
    numAccess = 0;
    currAccess = 0;
}
Vehicle::Vehicle( ifstream& readFile ){
    readFile >> idNum;
    readFile.ignore();
    getline( readFile, manufacturer );
    getline( readFile, color );
    readFile.ignore();
    readFile >> cost;
    readFile >> numAccess;

    readFile.ignore();
    for(int i=0; i<this->numAccess; i++){
        getline( readFile, listAccess[i] );
    }
}
Vehicle::Vehicle( const Vehicle& veh1){
    this->idNum = veh1.idNum;
    this->manufacturer = veh1.manufacturer;
    this->color = veh1.color;
    this->cost = veh1.cost;
    this->numAccess = veh1.numAccess;
    //listAccess[veh1.numAccess];
    for(int i=0; i < veh1.numAccess; i++){
        listAccess[i] = veh1.listAccess[i];
    }
}
Vehicle::~Vehicle(){  }
void Vehicle::operator=( const Vehicle& veh1){
    this->idNum = veh1.idNum;
    this->manufacturer = veh1.manufacturer;
    this->color = veh1.color;
    this->cost = veh1.cost;
    this->numAccess = veh1.numAccess;
    //listAccess[veh1.numAccess];
    for(int i=0; i < veh1.numAccess; i++){
        listAccess[i] = veh1.listAccess[i];
    }
}
bool Vehicle::operator==( const Vehicle& veh1 ){
    if((this->idNum == veh1.idNum) && (this->manufacturer == veh1.manufacturer) && (this->color == veh1.color) && (this->cost == veh1.cost) && (this->numAccess == veh1.numAccess)){
        return true;
    }else{
        return false;
    }
}
int Vehicle::getIdNum(){
    return idNum;
}
string Vehicle::getManufacturer(){
    return manufacturer;
}
string Vehicle::getColor(){
    return color;
}
double Vehicle::getCost(){
    return cost;
}
void Vehicle::startAcc(){
    currAccess = 0;
}
string Vehicle::nextAcc(){
    string temp = listAccess[currAccess];
    currAccess++;
    return temp;
}
bool Vehicle::hasNextAcc(){
    if(currAccess < numAccess){
        return true;
    }else{
        return false;
    }
}
