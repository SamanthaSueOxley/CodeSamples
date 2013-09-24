#!/usr/bin/perl
# Samantha Oxley
# Bonus Lab 05 - takes directory name as argument and prints the files within, and their sizes (bytes), last file modification & time.

use strict;
use warnings;

my $totalSize = 0;
my %allMods;
# this subroutine recoursively walks through directories, starting at the passed variable 
# and continuing into any child directories, it prints and gathers data on the files & dirs
sub recursion{
	my $dir = $_[0];
	opendir DIR, $dir or die "Enter a readable directory, $! is not readable\n";
	my @dirVals = grep { !/(^\.{1,2}$)/ }readdir(DIR);
	closedir DIR;
	foreach(@dirVals){
		# use full path for stat 
		my @info = stat($dir.'/'.$_);
		my $size = $info[7]||0;
		$totalSize += $size;
		# use full path for directory check
		if(-d $dir.'/'.$_){
			print "$dir/$_ is a dir of size $size. decending into...\n";
			&recursion($dir.'/'.$_);
		}else{
			my $lastModTime = $info[9];
			$allMods{$_} = $lastModTime;
			print "$_ is a file, size = $size\n";
		}
	}
}
# if the arg is defined, check for another arg, if 1 arg call recursion sub on argument1
if(defined $ARGV[0]){
	if(defined $ARGV[1]){
		print STDERR "Enter a directory\n";
		exit;	
	}else{
		&recursion($ARGV[0]);	
		# after the sub, sort through mod times and print data
		my @sort_mods = sort { $allMods{$b} <=> $allMods{$a} } keys(%allMods);
		my $lastTime = $allMods{$sort_mods[0]};
		my $lastFile = $sort_mods[0];
		my $lastPrintTime = localtime($lastTime);
		print "Total size is $totalSize\nLast file modified was: $lastFile\n";
		print "Last mod was $lastTime\n$lastPrintTime\n";
	}
}else{
	print STDERR "Enter a directory\n";
	exit;
}
