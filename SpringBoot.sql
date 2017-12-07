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
   
ALTER TABLE UserEntity
ADD CONSTRAINT emailFKeyOnUser
   FOREIGN KEY (email)
   REFERENCES Post (email);
