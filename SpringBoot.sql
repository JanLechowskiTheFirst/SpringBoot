CREATE TABLE users(
   id NUMBER(10) primary key NOT NULL,
   email VARCHAR2(30),
   pass VARCHAR2(30),
   enabled NUMBER DEFAULT 1 NOT NULL);

   CREATE TABLE post(
   id NUMBER(10) primary key NOT NULL,
   user_id NUMBER(10),
   post VARCHAR2(300),
   post_date timestamp(0) default systimestamp,
   CONSTRAINT fk FOREIGN KEY (user_id)
   REFERENCES users (id)
   );

  CREATE TABLE user_role(
  id NUMBER(10) primary key NOT NULL,
  user_id NUMBER(10),
  user_role VARCHAR2(15),
  CONSTRAINT roleKey UNIQUE (user_id, user_role),
  CONSTRAINT fk1 FOREIGN KEY (user_id)
  REFERENCES users (id)
  );

  CREATE SEQUENCE usr_id START WITH 1;

CREATE OR REPLACE TRIGGER usr_id
BEFORE INSERT ON users
FOR EACH ROW

BEGIN
  SELECT usr_id.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;


CREATE SEQUENCE pst_id START WITH 1;

CREATE OR REPLACE TRIGGER pst_id
BEFORE INSERT ON post
FOR EACH ROW

BEGIN
  SELECT pst_id.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE SEQUENCE usrl_id START WITH 1;

CREATE OR REPLACE TRIGGER usrl_id
BEFORE INSERT ON user_role
FOR EACH ROW

BEGIN
  SELECT usrl_id.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

INSERT INTO users(email,pass)
VALUES ('test','123');

INSERT INTO user_role(user_id,user_role)
VALUES ('1','ROLE_user');

INSERT INTO user_role(user_id,user_role)
VALUES ('2','ROLE_admin');

INSERT INTO users(email,pass)
VALUES ('admin','123');

INSERT INTO post(user_id,post)
VALUES ('1','This evening started realy bad');
