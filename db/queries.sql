Select query
//item types
=>INSERT
insert into item_types (typeName) value ("lapee");
=>UPDATE
UPDATE item_types SET typeName = "laptop" WHERE typeID = ?;
=>SELECT
SELECT * FROM item_types;
SELECT * FROM item_types WHERE typeID = ?;



//specifications
=>INSERT
insert into specifications (ramSize, storageSize, screenSize) values (8,256,15.6);
=> DELETE
DELETE * FROM specifications WHERE specID =?;
=>UPDATE
UPDATE specifications SET ramSize = ?, storageSize = ?, screenSize = 15.6 WHERE specID = ?;
=>SELECT 
SELECT * FROM specifications;
SELECT * FROM specifications WHERE specID = ?;


// items
insert into items (name,description,faulty,typeID, photo,serialNumber,labID,managerID, specID,createdAt,updatedAt,deleted) values ('lenovo','thinkpad e589',0,1,'','2323d3',1,2,1);
=>UPDATE
UPDATE items SET name = ?, description = ?,faulty = ?,  photo = ? WHERE itemID = ?;
=>DELETE
DELETE * FROM items WHERE itemID=?
=> SELECT
SELECT * FROM items;
SELECT * FROM itemID WHERE specID = ?;


// labs
insert into labs (labName,city,region,photo,createdAt,updatedAt,deleted) values ('Sawla lab','Sawla', 'Upper west','');
=>SELECT 
SELECT * FROM labs;
SELECT * FROM labs WHERE ladID = ?;
=>UPDATE
UPDATE labs SET labName = ?, city = ?, region = ?, photo = ? WHERE labID = ?;


//manager
=>INSERT
insert into managers (firstName, lastName,gender,phone, email,address,dob,photo,roleID,labID,createdAt,updatedAt,deleted) values ('John','Doe','male',0246859754,'johndoe@gmail.com','MA Street','1995/05/05','',1,1);
=>UPDATE
UPDATE managers
SET firstName = ?, lastName = ?, gender = ?,phone =?, email = ?, address = ?,dob = ?,photo = ?, updatedAt = ? WHERE managerID = 1;
=>SELECT
SELECT * FROM managers;
SELECT * FROM managers WHERE managerID =?;

//roles
=>INSERT
insert into roles (roleName) value ('Tecni');
=>SELECT
SELECT * FROM roles;
SELECT * FROM roles WHERE roleID = ?;
=>UPDATE
UPDATE roles SET roleName =? WHERE roleID =?


