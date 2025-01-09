# Hibernate Criteria Project

This project demonstrates the use of Hibernate Criteria interface for performing various database operations. The project includes fetching all records, fetching records based on certain conditions, and fetching specific columns using projections.

## Project Structure

- `src/main/java/com/hibernate/criteria/HIbernate_Criteria/App.java`: The main application file where the Hibernate Criteria operations are performed.
- `src/main/java/com/hibernate/criteria/HIbernate_Criteria/Product.java`: The entity class representing the `Product` table in the database.

## What is Hibernate Criteria?

Hibernate Criteria interface is a powerful and flexible way to query the database. It provides a way to build queries programmatically using Java objects and methods, rather than writing SQL queries directly. This makes the code more readable and maintainable.

### Criteria

- It is an interface present in the `org.hibernate` package.
- Provides an object-oriented approach to data retrieval from the database.
- Allows developers to build database queries programmatically using Java objects and methods rather than writing HQL or SQL strings.
- Always used to fetch bulk data.
- Cannot be used for DML or any DDL statements.
- Implementation is provided by invoking the `createCriteria()` method using the session instance.

### Restrictions

- The `Restrictions` class from the `org.hibernate.criterion` package defines methods used to filter the results, similar to the WHERE clause in SQL.

### Projections

- The `Projections` class from the `org.hibernate.criterion` package defines methods used to filter the results, similar to the SELECT clause in SQL.

## Operations Performed

### 1. Fetch All Records

The following code fetches all records from the `Product` table:

```java
Criteria criteria = session.createCriteria(Product.class); // Deprecated 
List<Product> products = criteria.list();
for(Product product: products) {
    System.out.println(product);
}
```

### 2. Fetch Records Based on Conditions

The following code fetches records based on certain conditions using `Restrictions`:

```java
Criteria criteria1 = session.createCriteria(Product.class); 

// Uncomment one of the following lines to apply the desired restriction
// criteria1.add(Restrictions.eq("productId",1));
// criteria1.add(Restrictions.gt("productId",3));
// criteria1.add(Restrictions.lt("productId",3));
// criteria1.add(Restrictions.between("productId", 2, 3));
// criteria1.add(Restrictions.like("productName", "watch"));

List<Product> products1 = criteria1.list();
for(Product product: products1) {
    System.out.println(product);
}
```

### 3. Fetch Specific Columns Using Projections

The following code fetches specific columns using `Projections`:

```java
Criteria criteria2 = session.createCriteria(Product.class);

criteria2.setProjection(Projections.property("productName"));
List<String> products2 = criteria2.list();
System.out.println("Fetching productNames");
for(String product: products2) {
    System.out.println(product);
}

criteria2.setProjection(Projections.property("productPrice"));
List<Integer> products3 = criteria2.list();
System.out.println("Fetching productPrice");
for(Integer product: products3) {
    System.out.println(product);
}
```

## How to Run the Project

1. Ensure you have a MySQL database set up with a `Product` table.
2. Update the Hibernate configuration file (`hibernate.cfg.xml`) with your database connection details.
3. Compile and run the `App.java` file.

## Conclusion

This project demonstrates the basic usage of Hibernate Criteria interface for performing various database operations. The Criteria interface provides a more flexible and readable way to build queries programmatically.
