# Book-Management
Implemented persistence frame work(Bridge,Command,Factory and Template pattern) using JAVA AWT/Swing


This application is a simple JAVA Swing application to develop using Persistence Frame work patterns. The application developed by applying Bridge,Command,Factory and Template pattern. MySQL DB is being used to store the book details. It has only one table (BookDescriptions). The fields of the table are given below.

ISBN Varchar(20),
Title Varchar(20), 
Author Varchar(20), 
price Number(10,2),
publisher Varchar(20), 
edition Number(4) 

How the application works and its functionality:
----------------------------------------------------------
When the application is up and running, user can see all the fields and the operation buttons. 

1)	Display Table Button: Will display the table to the user. The user can see all the data in the table.
2)	Insert Button: The user needs to enter all the fields and needs to hit Insert button, then the data is inserted into the database this can be verified by clicking the “Display Table” button.
3)	Update Button: The user needs to enter all the fields to update, or to avoid that the user can enter the “Isbn” and click the “Retrive Button” so that all the data are retrieved and displayed then the user can make changes to particular field and click update but the user needs to enter all the field to update.
4)	Delete Button: The user needs to enter Isbn fields alone and then if he clicks Delete button the entire row has been deleted and this can be viewed by clicking “Display Table”.
5)	Undo and Redo Button: Whenever the user modifies the DB content like inserting, updating or deleting the user can do undo or redo operation.
6)	Retrive Button: The user needs to enter the isbn number and when he clicks retrive button the entire row has been fetched and displayed to the user.

As said above its an overall functionality of the application. Below is the general workflow of the application. Operation can be any like insert, update, delete or retrieve. The controller will create objects for using it. Like InsertDataController will create an object for BookDescriptions and use it.

User -> (Operation) Button -> (Operation)DataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> (Operation)DB.

1)	Insert Operation:
User -> Insert Button -> InsertDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> InsertDB.

2)	Update Operation:
User -> Update Button -> UpdateDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> UpdateDB.

3)	Delete Operation:
User -> Delete Button -> DeleteDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> DeleteDB.

4)	Retrieve Operation:
User -> Retrive Button -> RetriveDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> RetriveDB.

5)	Undo Operation:
User -> Undo Button -> UndoDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> UndoDB.

6)	Redo Operation:
User -> Redo Button -> RedoDataController -> DatabaseManager -> DataBaseImpInterface-> RelationalDatabaseImpl -> RedoDB.
