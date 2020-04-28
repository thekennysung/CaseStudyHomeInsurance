drop table policys;
drop table property;
drop table quote;
drop table HomeownerInfo;
drop table Locations;
drop table Login;

create table Login(
USER_NAME varchar2(225) NOT NULL UNIQUE,
USER_PWD varchar2(225) NOT NULL,
ROLE varchar2(255) NOT NULL,

CHECK(LENGTH(USER_NAME)<20),
CHECK(LENGTH(USER_PWD)<20)
);


create table Locations(
QUOTE_ID NUMBER(10) GENERATED BY  DEFAULT AS IDENTITY(START WITH 1 INCREMENT BY 1),
RESIDENCE_TYPE VARCHAR2(255) NOT NULL,
ADDRESS_LINE_1 NVARCHAR2(500) NOT NULL,
ADDRESS_LINE_2 NVARCHAR2(500) DEFAULT NULL,
CITY VARCHAR2(255) NOT NULL,
LOCATION_STATE VARCHAR2(255) NOT NULL,
ZIP VARCHAR2(255) NOT NULL,
RESIDENCE_USE VARCHAR2(255) NOT NULL,
USER_NAME VARCHAR2(255) NOT NULL,
CONSTRAINT RESICENTTYPE_ck CHECK(RESIDENCE_TYPE IN ('Single-Family Home', 'Condo', 'Townhouse', 'Rowhouse', 'Duplex', 'Apartment')),
CONSTRAINT RESIDENCE_USE_ck CHECK( RESIDENCE_USE IN ('Primary', 'Secondary', 'Rental Property'))
);

CREATE TABLE HomeownerInfo(
QUOTE_ID NUMBER(10) NOT NULL,
FIRST_NAME VARCHAR2(225) NOT NULL,
LAST_NAME VARCHAR2(225) NOT NULL,
DOB VARCHAR2(225) NOT NULL,
IS_RETIRED VARCHAR2(255) NOT NULL,
SSN VARCHAR2(255) NOT NULL,
EMAIL_ADDRESS VARCHAR2(255) NOT NULL,

CHECK(LENGTH(FIRST_NAME)<31),
CHECK(LENGTH(LAST_NAME)<31),
CHECK(LENGTH(DOB)<11),
CHECK(LENGTH(SSN)<10),
CHECK(LENGTH(EMAIL_ADDRESS)<51)
);

CREATE TABLE Quote(
QUOTE_ID NUMBER(10) NOT NULL UNIQUE,
PREMIUM NUMBER(10, 2) NOT NULL,
DWELLING_COVERAGE NUMBER(10, 2) NOT NULL,
DETACHED_STRUCTURE NUMBER(10, 2) NOT NULL,
PERSONAL_PROPERTY NUMBER(10, 2) NOT NULL,
ADDNL_LIVING_EXPENSE NUMBER(10, 2) NOT NULL,
MEDICAL_EXPENSE NUMBER(10, 2) NOT NULL,
DEDUCTIBLE NUMBER(10, 2) NOT NULL
);

CREATE TABLE Property(
QUOTE_ID NUMBER(10) NOT NULL,
MARKET_VALUE NUMBER(10) NOT NULL,
YEAR_BUILT NUMBER(10) NOT NULL,
SQUARE_FOOTAGE NUMBER(10) NOT NULL,
DWELLING_STYLE decimal(10,2) NOT NULL,
ROOF_MATERIAL VARCHAR2(255) NOT NULL,
GARAGE_TYPE VARCHAR2(255) NOT NULL,
NUM_FULL_BATHS NUMBER(10) NOT NULL,
NUM_HALF_BATHS NUMBER(10) NOT NULL,
HAS_SWIMMING_POOL VARCHAR2(255) DEFAULT 'FALSE' NOT NULL 
);

CREATE TABLE Policys(
POLICY_KEY VARCHAR2(255) NOT NULL,
QUOTE_ID NUMBER(10) NOT NULL,
POLICY_EFFECTIVE_DATE VARCHAR2(255) NOT NULL,
POLICY_END_DATE VARCHAR2(255) NOT NULL,
POLICY_TERM VARCHAR2(255) NOT NULL,
POLICY_STATUS VARCHAR2(255) NOT NULL,
CONSTRAINT POLICY_DATE_CK CHECK( POLICY_EFFECTIVE_DATE < POLICY_END_DATE )
);

commit;

Insert into login(USER_NAME, USER_PWD, ROLE) VALUES ('admin', 'admin', 'Admin');
select * from login;
select * from HomeownerInfo;
select * from Locations;
select * from Property;
select * from QUOTE;
select * from policys;


SELECT * FROM Login where USER_NAME = 'kenny';

select * from Locations where USER_NAME = 'kenny';
