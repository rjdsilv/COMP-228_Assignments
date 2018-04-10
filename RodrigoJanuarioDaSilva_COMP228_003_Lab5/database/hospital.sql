DROP TABLE Hospitals;

CREATE TABLE Hospitals
(
	HospitalID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	Name VARCHAR (50) NOT NULL,
	Address VARCHAR (254) NOT NULL,
	FaxNumber VARCHAR (15) NOT NULL,
	PhoneNumber VARCHAR (15) NOT NULL,
	Email VARCHAR (50) NOT NULL,
	Rating INTEGER NOT NULL

);

INSERT INTO Hospitals (Name,Address,FaxNumber,PhoneNumber,Email,Rating)
	VALUES ('St. Mikes Hospital','88 Yonge Street','222-2222','555-5555','mikes@hospital.com', 10),
	('St. Marys Hospital','234 Brown Avenue','333-3333','555-1234','mary@hospital.com', 9);