USE notice;
 CREATE TABLE USER_DETAILS(
  USER_ID INT PRIMARY KEY,
  USER_NAME VARCHAR(20)
 );
 
 COMMIT;
INSERT INTO USER_DETAILS VALUES(
1,"REVATHI");
INSERT INTO USER_DETAILS VALUES(
2,"AKHILA");
INSERT  INTO USER_DETAILS VALUES(
3,"HARSHITHA");
INSERT INTO USER_DETAILS VALUES(
4,"AVINASH");
INSERT INTO USER_DETAILS VALUES(
5,"NEERAJ");

SELECT * FROM USER_DETAILS;

CREATE TABLE USER_POST(
POST_ID INT PRIMARY KEY,
USER_ID INT,
FOREIGN KEY (USER_ID) REFERENCES USER_DETAILS(USER_ID),
CONTENT VARCHAR(255));

INSERT INTO USER_POST VALUES(
1,1,"GOOD MORNING");
INSERT INTO USER_POST VALUES(
2,1,"HI EVERYONE");
INSERT INTO USER_POST VALUES(
3,5,"HI HELLO");
INSERT INTO USER_POST VALUES(
4,2,"HI REVATHI");
INSERT INTO USER_POST VALUES(
5,3,"WHATS UP?");

CREATE TABLE USER_LIKES(
USER_ID INT,
POST_ID INT,
PRIMARY KEY(USER_ID , POST_ID),
FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID), 
FOREIGN KEY(POST_ID) REFERENCES USER_POST(POST_ID)
);

INSERT INTO USER_LIKES VALUES(
4,3);

SELECT * FROM USER_LIKES;

CREATE TABLE USER_COMMENTS(
USER_ID INT,
POST_ID INT,
FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID), 
FOREIGN KEY(POST_ID) REFERENCES USER_POST(POST_ID),
CONTENT VARCHAR(250)
);

INSERT INTO USER_COMMENTS VALUES(
3,1,"ALRIGHT!!");

SELECT * FROM USER_COMMENTS;































































