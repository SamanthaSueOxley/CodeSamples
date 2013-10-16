/*
    Samantha Oxley
    C++ Lab 06
    OOP- Commission Class to
*/

class Commission{
    private:
        int id;
        double baseSal;
        double amtSales;
        double commRate;
    public:
        Commission();
        Commission(int, double, double, double);
        ~Commission();
        bool setIdNum(int);
        bool setBase(double);
        bool setSales(double);
        bool setRate(double);
        int getIdNum();
        double getBase();
        double getRate();
        double getSales();
        double calcSalary();
};

Commission::Commission(){
    id = 0;
    baseSal = 0.0;
    amtSales = 0.0;
    commRate = 0.0;
    cout << "In default constructor." << endl;
}
Commission::Commission(int _id, double _baseSal, double _amtSales, double _commRate){
    id = _id;
    baseSal = _baseSal;
    amtSales = _amtSales;
    commRate = _commRate;
    cout << "In initializing constructor." << endl;
}
Commission::~Commission(){
    cout << "In destructor of id num... " << id << endl;
}
bool Commission::setIdNum(int _id){
    if(_id > 0 && _id < 999){
        id = _id;
        return true;
    }else{
        return false;
    }
}
bool Commission::setBase(double _baseSal){
    if(_baseSal > 0.00){
        baseSal = _baseSal;
        return true;
    }else{
        return false;
    }
}
bool Commission::setSales(double _amtSales){
    if(_amtSales > -1.00){
        amtSales = _amtSales;
        return true;
    }else{
        return false;
    }
}
bool Commission::setRate(double _commRate){
    if(_commRate > 0.00 && _commRate <= 0.20){
        commRate = _commRate;
        return true;
    }else{
        return false;
    }
}
int Commission::getIdNum(){
    return id;
}
double Commission::getBase(){
    return baseSal;
}
double Commission::getSales(){
    return amtSales;
}
double Commission::getRate(){
    return commRate;
}
double Commission::calcSalary(){
    double comm = baseSal + amtSales * commRate;
    return comm;
}
