-- Data for users table
INSERT INTO users (username,password,enabled) VALUES ('anushan','anushan.1',true);

INSERT INTO users (username,password,enabled) VALUES ('nimesh','nimesh.1',true);

-- Data for authorities table
INSERT INTO authorities (username,authority) VALUES ('anushan','ROLE_ADMIN');

INSERT INTO authorities (username,authority) VALUES ('nimesh','ROLE_USER');

