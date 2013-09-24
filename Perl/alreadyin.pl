#!/usr/bin/perl
# Samantha Oxley
# Task 1 Lab 04 - check for existence of multiple usernames in a file 
use strict;
use warnings;

my $users = $ARGV[0];
my $data = $ARGV[1];
if(defined $users && defined $data){
	# open the first file of usernames and save them to array
	open FILE, $users or die "Cannot open file $!\n";
	my @theUsers = <FILE>;
	close FILE;
	# open the second file to compare to, save lines to an array
	open FILE, $data or die "Cannot open file $!\n";
	my @theData = <FILE>;
	close FILE;
	foreach my $line (@theUsers){
		if($line eq "" || $line eq " "){
			
		}else{
			my @elements = split(/ /, $line);
			my $username = pop @elements;
			chomp $username;
			if($username eq "" || $username eq " "){

			}else{
				foreach my $line2 (@theData){
					my @eles = split(/:/, $line2);
					my $fullname = $eles[4];
					if((index($line2, $username)) != -1){
						print "$username already exists: $fullname\n"; 
					}else{ }
				}
			}
		}
	}
}else{
	print STDERR "Usage: ./alreadyin input_file  passwd_file\n";
	exit;
}
