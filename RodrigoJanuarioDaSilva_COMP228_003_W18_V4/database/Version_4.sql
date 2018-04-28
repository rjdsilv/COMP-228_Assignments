DROP TABLE Tools;

CREATE TABLE Tools (
   toolID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   price INT NOT NULL,
   category VARCHAR (20) NOT NULL,
   toolType VARCHAR (20) NOT NULL,
   brand VARCHAR (20) NOT NULL,
   PRIMARY KEY (toolID)
);

INSERT INTO Tools (price, category, toolType, brand)
values 
 (50, 'garden', 'Shovel', 'Botanica'),
 (35, 'construction', 'Hammer', 'Estwing'),
 (15, 'sawing', 'Needle', 'Schments');
