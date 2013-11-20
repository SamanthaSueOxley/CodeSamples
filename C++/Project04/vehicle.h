/*
    Samantha Oxley
    Project 04 - 11/13/13
    Vehicle class -
        will store information on vehicles
*/
#ifndef VEHICLE_H
#define VEHICLE_H

#include <iostream>
#include <fstream>
#include <string>
using namespace std;


class Vehicle{
    private:
        int idNum;
        std::string manufacturer;
        std::string color;
        double cost;
        int numAccess;
        int currAccess;
        std::string listAccess[50];
    public:
        Vehicle();
        Vehicle( ifstream& );
        Vehicle( const Vehicle& );
        ~Vehicle();
        void operator=( const Vehicle& );
        bool operator==( const Vehicle& );
        int getIdNum();
        std::string getManufacturer();
        std::string getColor();
        double getCost();
        void startAcc();
        std::string nextAcc();
        bool hasNextAcc();
};

#endif // VEHICLE
