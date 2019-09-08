CREATE TABLE `role` (
  `ROLE_ID` int(11) NOT NULL,
  `TYPE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cnam_attendance_db`.`person` (
  `PERSON_ID` INT NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `FIRSTNAME` VARCHAR(45) NULL,
  `LASTNAME` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(45) NULL,
  `ROLE_ROLE_ID` INT NULL,
  PRIMARY KEY (`EMAIL`));

INSERT INTO ROLE (ROLE_ID, TYPE) VALUES (10, 'Student');
INSERT INTO ROLE (ROLE_ID, TYPE) VALUES (20, 'Teacher');
INSERT INTO ROLE (ROLE_ID, TYPE) VALUES (30, 'Admin');

INSERT INTO PERSON (PERSON_ID, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, ROLE_ROLE_ID) VALUES (1000000, 'admin@admin.com', 'admin', 'admin', 'adminadmin', 30);
INSERT INTO PERSON (PERSON_ID, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, ROLE_ROLE_ID) VALUES (1, 'admin@admin.com', 'admin', 'admin', 'adminadmin', 30);


INSERT INTO `CNAM_Attendance_DB`.`PERIOD` (`PERIODCODE`, `PERIODMONDAYTOFRIDAY`, `PERIODSATURDAY`, `USEDINMONDAYTOFRIDAY`, `USEDINSATURDAY`) VALUES ('P1', NULL, '12:30pm -> 2pm', '0', '1');

INSERT INTO `CNAM_Attendance_DB`.`PERIOD` (`PERIODCODE`, `PERIODMONDAYTOFRIDAY`, `PERIODSATURDAY`, `USEDINMONDAYTOFRIDAY`, `USEDINSATURDAY`) VALUES ('P2', '4pm -> 5:30pm', '2:15pm ->3:45pm', '1', '1');

INSERT INTO `CNAM_Attendance_DB`.`PERIOD` (`PERIODCODE`, `PERIODMONDAYTOFRIDAY`, `PERIODSATURDAY`, `USEDINMONDAYTOFRIDAY`, `USEDINSATURDAY`) VALUES ('P3', '5:45pm -> 7:15pm', '4pm -> 5:20pm', '1', '1');

INSERT INTO `CNAM_Attendance_DB`.`PERIOD` (`PERIODCODE`, `PERIODMONDAYTOFRIDAY`, `PERIODSATURDAY`, `USEDINMONDAYTOFRIDAY`, `USEDINSATURDAY`) VALUES ('P4', '7:30pm -> 9:00pm', '', '1', '0');

COMMIT;

