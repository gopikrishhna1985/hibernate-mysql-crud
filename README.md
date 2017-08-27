# hibernate-mysql-crud
A Simple Hibernate MySQL example explaining the CRUD operations

Load() - helps to load the data from database into the java object, it can be done in three way, pass the class, pass the entire package (entity name), pass the object of the Entity Object with id for all three cases ( for ex : load(Employee.class, empid)) 

Get() - same as that of load()… two ways… entity class, entity name(i.e full package) 
But the difference between these two is - > if the identifier does not exist in database”. In case of get() method you will get return value as NULL if identifier is absent; But in case of load() method, you will get a runtime exception 
Get() will hit the database all the time, load() will not hit the database 
 
Refresh() - it's used to refresh the Entity Object with the latest values from the database 

Merge() - used to merge the updated entity (detached Entity) Object into the database… 
ts merges the updated data with the entity in the memory before updating the database… 
errors like NonUniqueObjectException and "a different object with the same identifier value was already associated with the session" can be addressed if using merge… if you try to work on detached object without reattaching them and try to update() u will get the above error, in this case use merge 
 
Save() - insert only 

SaveOrUpdate() - both insert or update depending upon the data 

Persist() - same as save() 
Difference between save and persist 
Save returns serializable object, persist does not return anything 
Save executes insert outside transaction boundary resulting in duplicate(when you use generated value), persist does not allow to execute outside transaction 
Save not good for long running conversations, persist good for long running conversation 
Persist is better to use than save 

Delete() - used to delete the record
