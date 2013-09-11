-- Samantha Oxley
-- Database w/ Jim Habermas - 360.01
-- 2/7/2013

-- Query 1
SELECT concat(publisher.city, ', ', state.statecode) AS Location, COUNT(publisher.name) AS Count FROM state JOIN publisher ON state.statecode = publisher.statecode GROUP BY Location;
-- Query 2
SELECT book.title, COUNT(bookreview.rating) AS 'Total Ratings', MIN(bookreview.rating) AS 'Low', MAX(bookreview.rating) AS 'High', 
	ROUND(AVG(bookreview.rating),2) AS 'Average' FROM book LEFT JOIN bookreview ON book.isbn = bookreview.isbn 
	GROUP BY book.title ORDER BY COUNT(bookreview.rating) DESC, AVG(bookreview.rating) DESC;
-- Query 3
SELECT publisher.Name, COUNT(publisher.Name) as 'Book Count' FROM publisher JOIN book ON publisher.publisherID = book.publisherID 
	GROUP BY publisher.Name HAVING COUNT(publisher.Name) > 2 ORDER BY COUNT(publisher.Name) DESC;
-- Query 4
SELECT Title, char_length(Title) AS Length, SUBSTR(Title, locate('bill', Title) + 4) AS 'After Bill' FROM book WHERE Title LIKE '%bill%';
-- Query 5
SELECT book.Title FROM ownersbook JOIN book ON ownersbook.ISBN = book.ISBN WHERE ownersbook.TransactionFlag = 's';