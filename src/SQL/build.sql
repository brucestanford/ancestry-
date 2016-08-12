CREATE TABLE Company
(
Company_ID int NOT NULL AUTO_INCREMENT,
Company_Name varchar(255) NOT NULL,
note varchar(255),
PRIMARY KEY (Company_ID )
);


CREATE TABLE Zoo
(
Zoo_ID int NOT NULL AUTO_INCREMENT,
Company_ID int NOT NULL,
Zoo_Name varchar(255) NOT NULL,
note varchar(255),
PRIMARY KEY (Zoo_ID )
);

CREATE TABLE Species
(
Species_ID int NOT NULL AUTO_INCREMENT,
Name varchar(255) NOT NULL,
note varchar(255),
PRIMARY KEY (Species_ID )
);


CREATE TABLE Animal
(
Animal_ID int NOT NULL AUTO_INCREMENT,
Zoo_ID int NOT NULL,
Species_ID int NOT NULL,
Animal_Name varchar(255) NOT NULL,
Description varchar(255),
Health varchar(255),
TimesToFeedADay int NOT NULL,
AmountToFeedEachTime int NOT NULL,
note varchar(255),
PRIMARY KEY (Animal_ID )
);


CREATE TABLE Feed
(
Feed_ID int NOT NULL AUTO_INCREMENT,
Feed_Name varchar(255) NOT NULL,
Description varchar(255),
Quantity_Left int NOT NULL,
Reorder_Quanty int NOT NULL,
OnReorder int NOT NULL,
note varchar(255),
PRIMARY KEY (Feed_ID )
);

CREATE TABLE Log_of_Feeding
(
Log_of_Feeding_ID int NOT NULL AUTO_INCREMENT,
Animal_ID int NOT NULL,
Feed_ID int NOT NULL,
Quantity int NOT NULL,
Time_of_Day24Hour BIGINT NOT NULL,
Date_of_Feeding  DATE NOT NULL,
Recorded_Flag int,
note varchar(255),
PRIMARY KEY (Log_of_Feeding_ID)
);
