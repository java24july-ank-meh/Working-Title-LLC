Create table CUSTOMER (
    customerID NUMBER(*,0),
    username VARCHAR2(30),
    password VARCHAR2(30),
    email VARCHAR2(60),
    locked NUMBER(1,0)
);

Create table INVENTORY (
    itemID NUMBER(*,0),
    cardname VARCHAR2(200),
    game VARCHAR2(30),
    cardID NUMBER(*,0)
);


