CREATE TABLE UserEntity(
   email VARCHAR2(30) primary key,
   pass VARCHAR2(30)
   );
   

CREATE TABLE Post(
   email VARCHAR2(30) primary key,
   post VARCHAR2(300),      
   postDate timestamp(0) default systimestamp,
   CONSTRAINT emailFKey FOREIGN KEY (email)
   REFERENCES UserEntity (email)
   );
   

CREATE TABLE UserRole(
  email VARCHAR2(30) PRIMARY KEY,
  userRole VARCHAR2(15),
  CONSTRAINT roleKey UNIQUE (email, userRole),
  CONSTRAINT emailKey FOREIGN KEY (email)
  REFERENCES UserEntity (email)
  );

  INSERT INTO USERENTITY(email,pass)
  VALUES ('test','123');

  INSERT INTO USERROLE(email,userrole)
  VALUES ('test','user');

  ALTER TABLE USERENTITY
  ADD enabled NUMBER DEFAULT 1 NOT NULL;
