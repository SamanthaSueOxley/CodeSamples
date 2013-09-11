-- Samantha Oxley
-- Jim Habermas 360.01
-- Practice Excercise 15

-- Query 1
select passenger.FName, passenger.LName, passenger.Street, zips.City, zips.State, zips.Zip FROM passenger JOIN zips on zips.Zip = passenger.Zip ORDER BY passenger.LName asc;
-- Query 2
select trip.TripNum, trip.DepartureTime, trip.DepartureLocCode FROM trip JOIN trip_directory ON trip.TripNum = trip_directory.TripNum 
			JOIN tripcodes ON tripcodes.TripType = trip_directory.TripType where tripcodes.TypeName="Bus";
-- Query 3
select concat(passenger.FName,' ',passenger.LName) AS Passenger FROM passenger JOIN trip_people WHERE passenger.passengerID = trip_people.passengerID GROUP BY FName, Date HAVING month(trip_people.Date)=10;
-- Query 4
SELECT locations.Location, COUNT(trip_directory.DepartureLocCode) AS "Number of Departures" FROM trip_directory LEFT JOIN locations ON locations.LocationCode = trip_directory.DepartureLocCode GROUP BY locations.Location;
-- Query 5
SELECT Name FROM staff JOIN trip_directory ON staff.TripNum = trip_directory.TripNum WHERE DATE="2005-08-14" AND DepartureLocCode="BOS" AND ArrivalLocCode="NAS";
-- Query 6
SELECT COUNT(trip_people.TripNum) AS "People to meet" FROM passenger JOIN trip_people ON passenger.PassengerID = trip_people.PassengerID
			JOIN trip_directory ON trip_directory.TripNum = trip_people.TripNum
			JOIN staff ON staff.TripNum = trip_directory.TripNum
			JOIN locations ON locations.LocationCode = trip_directory.DepartureLocCode 
			WHERE locations.Location="Frankfort";
-- Query 7
SELECT FName, LName FROM passenger JOIN trip_people ON passenger.PassengerID = trip_people.PassengerID
			JOIN trip_directory ON trip_people.TripNum = trip_directory.TripNum 
			JOIN tripcodes ON trip_directory.TripType = tripcodes.TripType
			JOIN zips ON passenger.Zip = zips.Zip 
			WHERE tripcodes.TypeName="Bus" AND zips.City="Rochester";
-- Query 8
SELECT equipment.EquipmentDescription FROM passenger JOIN trip_people ON passenger.PassengerID = trip_people.PassengerID
			JOIN trip ON trip.TripNum = trip_people.TripNum 
			JOIN equipment ON equipment.EquipID = trip.EquipID 
			WHERE passenger.FName = "Curtis" AND passenger.LName = "Brown";
-- Query 9
SELECT COUNT(tripcodes.TypeName) AS "Plane People" FROM passenger JOIN trip_people ON passenger.PassengerID = trip_people.PassengerID
			JOIN trip_directory ON trip_directory.TripNum = trip_people.TripNum
			JOIN tripcodes ON trip_directory.TripType = tripcodes.TripType 
			WHERE tripcodes.TypeName="Plane";
-- Query 10
select distinct trip_people.tripnum, trip_people.date FROM (((trip_people JOIN trip_directory ON trip_people.tripnum = trip_directory.tripnum)
			JOIN passenger ON trip_people.passengerID=passenger.passengerID)
			JOIN phones ON phones.passengerID = passenger.passengerID)
			JOIN tripcodes ON trip_directory.triptype = tripcodes.triptype 
			WHERE phones.phonetype LIKE "Cell" AND tripcodes.triptype LIKE "P";

