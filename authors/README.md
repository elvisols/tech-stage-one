# Getting Started

RESTApi request to pull all authors records and return the following.

1. The list of most active authors according to a set threshold (`http://~:8088/authors/active-list/3`).
2. The author with the highest comment count(`http://~:8088/authors/highest-comment-count`).
3. The list of the authors sorted by when their record was created according to a set threshold(`http://~:8088/authors/created-list/3`).

### Application Requirements:

- Java 8
- Maven 3+
- Internet connection

### Assumptions

> The following port is available:

- 8088

### Running the Application:

> Expose REST Endpoints

```
~$ mvn clean package
```

```
~$ mvn spring-boot:run
```

You should be able to access the application on `http://~:8088/`

## --
