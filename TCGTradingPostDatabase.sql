
/* Create tables */
Create table TCGTP_USERS (
    userID NUMBER(*,0) primary key,
    username VARCHAR2(30),
    password VARCHAR2(30),
    email VARCHAR2(60),
    locked NUMBER(1,0),
    userroleID NUMBER(2,0)
    
);

Create table INVENTORY (
    itemID NUMBER(*,0) primary key,
    cardname VARCHAR2(200),
    game VARCHAR2(30),
    cardID NUMBER(*,0),
    price NUMBER(*,2),
    stock NUMBER(*,0)
);

Create table ORDERSTATUS (
    statusID NUMBER(2,0) primary key,
    statusName VARCHAR2(30) unique
);

Create table ORDERITEM (
    orderItemID NUMBER(*,0) primary key,
    itemName VARCHAR2(200),
    itemID NUMBER(*,0),
    quantity NUMBER(*,0),
    orderID NUMBER(*,0)
);

Create table ORDERS (
    orderID NUMBER(*,0) primary key,
    customerID NUMBER(*,0),
    datePlaced TIMESTAMP,
    shippingAddress VARCHAR2(200),
    statusID NUMBER(*,0)
);


