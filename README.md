# Lab Sign-In

A Spring Boot web app that lets students sign in to a computer lab. It collects their name and Valencia College email, validates the input, and stores each submission in a local H2 database.

---

## What It Does

Students fill out a simple form at the root URL. If the email doesn't end in `@mail.valenciacollege.edu`, the form rejects it and shows an error. If it's valid, the record gets saved and a confirmation page shows the submitted info. That's pretty much it.

---

## Stack

- Java 17
- Spring Boot 
- Thymeleaf (HTML templates)
- Spring Data JPA + Hibernate
- H2 embedded database
- Gradle

---

## Project Layout

```
src/main/java/com/example/labsignin/
├── LabSignInApplication.java   # boots the app
├── Student.java                # maps to the STUDENT table
├── StudentRepository.java      # handles DB operations via CrudRepository
└── StudentController.java      # handles GET / and POST /submit

src/main/resources/
├── templates/
│   ├── index.html              # sign-in form
│   └── success.html            # confirmation page
└── application.properties      # DB config
```

---

## Running It

Make sure you have Java 17+, then:

```bash
git clone https://github.com/YOUR_USERNAME/labSignIn.git
cd labSignIn
./gradlew bootRun
```

Then open `http://localhost:8080` in your browser.

If you're using IntelliJ, just open the project and run `LabSignInApplication.java` directly.

---

## Viewing Submitted Records

The app uses a file-based H2 database. While the app is running, go to:

```
http://localhost:8080/h2-console
```

Login info:
- **JDBC URL:** `jdbc:h2:file:./data/labsignindb_v2`
- **Username:** `admin`
- **Password:** `password`

Once connected:

```sql
SELECT * FROM STUDENT;
```

---

## Configuration

Found in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./data/labsignindb_v2
spring.datasource.username=admin
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
