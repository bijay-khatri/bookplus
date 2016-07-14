-- The Spring loads this data into db , add your required data seeder below

INSERT INTO Category VALUES (1,'About society and Politics','Society and Politics','');
INSERT INTO Category VALUES (2,'Description-Category-02','Dreams Unlimited','');
INSERT INTO Category VALUES  (3,'Description of Object Oriented Programming','Object Oriented Programming','');
INSERT INTO Category VALUES  (4,'Description-Category-04','Category-04','\0');
INSERT INTO Category VALUES (5,'Description-Category-05','Women and Empowerment','\0');
INSERT INTO Category VALUES (6,'Description of Science and Fiction','Science and Fiction','');

INSERT INTO Product VALUES (1,'Book About Java',40,NULL,'JAVA 8',123,'ACTIVE',2);
INSERT INTO Product VALUES  (2,'Hello Book',22,NULL,'Programming with C#',444,'ACTIVE',2);
INSERT INTO Product VALUES (3,'Python Programming',12,NULL,'Fun with Python',433,'ACTIVE',1);
INSERT INTO Product VALUES (4,'Society and its role',11,NULL,'Society and Its Role',555,'ACTIVE',3);
INSERT INTO Product VALUES (5,'No Description',41,NULL,'Dreamy Girl',555,'ACTIVE',2);
INSERT INTO Product VALUES (6,'HNo Description',0,NULL,'Women Enterprenureship',455,'ACTIVE',5);
INSERT INTO Product VALUES (7,'No Description',41,NULL,'Head First Java',555,'ACTIVE',3);

INSERT INTO Book VALUES (NULL,'001-0000000001',1);
INSERT INTO Book VALUES (NULL,'001-0000000002',2);
INSERT INTO Book VALUES (NULL,'001-0000000003',3);
INSERT INTO Book VALUES (NULL,'001-0000000004',4);
INSERT INTO Book VALUES (NULL,'001-0000000005',5);
INSERT INTO Book VALUES (NULL,'001-0000000006',6);
INSERT INTO Book VALUES (NULL,'001-0000000007',7);

-- Product Copy
INSERT INTO Product_Copy VALUES (1,1);
INSERT INTO Product_Copy VALUES (2,1);
INSERT INTO Product_Copy VALUES (3,2);
INSERT INTO Product_Copy VALUES (4,2);
INSERT INTO Product_Copy VALUES (5,3);
INSERT INTO Product_Copy VALUES (6,4);
INSERT INTO Product_Copy VALUES (7,4);
INSERT INTO Product_Copy VALUES (8,4);
INSERT INTO Product_Copy VALUES (9,4);
INSERT INTO Product_Copy VALUES (10,5);
INSERT INTO Product_Copy VALUES (11,6);
INSERT INTO Product_Copy VALUES (12,7);
INSERT INTO Product_Copy VALUES (13,7);

INSERT INTO user(first_name, last_name,email,password,role,admin_enabled,zip) VALUES ('test','ltest','admin','admin123','ROLE_ADMIN',1,52557);
