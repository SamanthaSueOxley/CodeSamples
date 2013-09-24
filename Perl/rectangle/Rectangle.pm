package Rectangle;
# Samantha Oxley
# Rectangle Class - has $length & $width
use strict;
use warnings;
use Scalar::Util qw(blessed);
our $Version = '0.01';
our @ISA = ();

sub new{
	my ($class, $length, $width) = @_;
	my $rectangle = {
		'length' => $length,
		'width' => $width,
	};
	bless $rectangle, $class;
	return $rectangle;
}
sub modWidth{
	my ($rectangle, $newWidth) = @_;
	$rectangle->{'width'} = $newWidth;
	return "New width: $rectangle->{'width'}\n";
}
sub modLength{
	my ($rectangle, $newLength) = @_;
	$rectangle->{'length'} = $newLength;
	return "New length: $rectangle->{'length'}\n";
}
sub getWidth{
	my ($rectangle) = @_;
	return $rectangle->{'width'};
}
sub getLength{
	my ($rectangle) = @_;
	return $rectangle->{'length'};
}
sub toString{
	my ($rectangle) = @_;
	return "Length is: $rectangle->{'length'}\nWidth is: $rectangle->{'width'}\n";
}
1;
