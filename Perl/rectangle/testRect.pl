#!/usr/bin/perl
# Samantha Oxley
# testRect.pl - uses the Rectangle module

use strict;
use warnings;
use Rectangle;

# using arrow notation
print "Creating a rectangle...\n";
my $rect = Rectangle->new("5","4");

my $width = $rect->getWidth();
print "Width: $width\nModifying the width...\n";
my $newWidth =  modWidth $rect "99";
print $newWidth;

my $length = $rect->getLength();
print "Length: $length\nModifying the length...\n";
my $newLength =  modLength $rect "25";
print $newLength;

print "Calling toString...\n" . $rect->toString();

