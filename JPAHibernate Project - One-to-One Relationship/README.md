**JPA/Hibernate Project - One-to-One Relationship**

This JPA/Hibernate project demonstrates how to create a One-to-One relationship between two entities, `User` and `Post`. The project follows the best practices of DAO and Service layer patterns to perform CRUD (Create, Read, Update, Delete) operations on the corresponding database tables.

**Project Structure**

The project is structured as follows:
├───src
    ├───main
        ├───java
        │   ├───dao
        │   │    ├── UserDao.java
        │   │    └── PostDao.java   
        │   ├───entities
        │   │    ├── User.java
        │   │    └── Post.java
        │   └───service
        │   │    ├── UserService.java
        │   │    └── PostService.java
        │   └── App.java
        │
        └───resources
            └───META-INF
                └───persistence.xml

-   `User.java` and `Post.java` files are marked as JPA entities with the `@Entity` annotation. They also include `@Table` annotations to specify the database table names.
    
-   `UserDao.java` and `PostDao.java` are DAO classes that include methods for performing CRUD operations on the corresponding database tables.
    
-   `UserService.java` and `PostService.java` are Service classes that include methods for performing business logic and interact with the database.
    
-   `persistence.xml` file contains the JPA configuration details, including the database connection settings and the entity classes that should be managed by JPA.

**Technologies Used**

-   Java 19
-   JPA
-   Hibernate
-   Lombok

**Key Features**

-   One-to-One relationship between `User` and `Post` entities.
-   Implementation of DAO and Service layer patterns.
-   CRUD operations on the corresponding database tables.
-   JPA/Hibernate configuration details specified in `persistence.xml`.

**Conclusion**

In summary, this JPA/Hibernate project provides a clear understanding of how to create a One-to-One relationship between two entities, `User` and `Post`. It also demonstrates the use of DAO and Service layer patterns to perform CRUD operations on the corresponding database tables. The project structure is well organized, and the use of annotations makes it easier to understand the code.

