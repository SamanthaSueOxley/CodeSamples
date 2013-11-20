
/* Samantha Oxley- prof: T.J. Borrelli
 * File: Box.h
 * Purpose:  Declaration of Box class
 *           inherits rectangle
 */

#ifndef Box_H
#define Box_H
#include "rectangle.h"

class Box : public Rectangle{
private:
    double height; //height of Box

public:
    //constructors
    Box( );
    Box(double length, double width, double height);

    //destructor
    ~Box( );

    //accessors
    double getHeight() const;

    //other
    double calcVolume() const;
    void   print( ) const;
};

#endif
