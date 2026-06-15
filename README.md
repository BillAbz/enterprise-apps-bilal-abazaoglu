Enterprise Apps Bilal Abazaoglu
Project Description

This project was developed for the Enterprise Applications course.

The application is a prototype website for an NGO in Anderlecht that focuses on community building and supporting people with fewer financial resources.

The application allows users to:

View the latest events
Add new events
View event details
Read information about the NGO
Contact the organisation through a contact form
Technologies Used
Java 21
Spring Boot
Spring MVC
Thymeleaf
Spring Data JPA
Hibernate
H2 Database
Lombok
Tailwind CSS
Project Structure
Models
Event
Location
ContactMessage
Controllers
EventController
PageController
ContactController
Repository
EventRepository
Pages
Index
New Event
Event Details
About
Contact
Database

This project uses an H2 in-memory database.

No additional database installation is required.

H2 Console:

http://localhost:8080/h2-console

Connection settings:

JDBC URL: jdbc:h2:mem
Username: sa
Password: (empty)
How to Run
Clone the repository.
Open the project in IntelliJ IDEA.
Wait for Maven dependencies to download.
Run EnterpriseAppBilalAbazaogluApplication.
Open:

http://localhost:8080

Contact Form

The contact form uses Spring Validation.

Mailtrap can be configured by adding SMTP credentials to application.properties.

Tutorials and Documentation
Spring Boot Documentation: https://spring.io/projects/spring-boot
Thymeleaf Documentation: https://www.thymeleaf.org/documentation.html
Spring Data JPA Documentation: https://spring.io/projects/spring-data-jpa
Tailwind CSS Documentation: https://tailwindcss.com/docs
AI Usage

ChatGPT was used to:

Explain Spring Boot concepts
Review code structure
Assist with debugging
Improve HTML and Thymeleaf templates

All generated code was reviewed, tested and adapted before being included in the final project.

Author

Bilal Abazaoglu
Enterprise Applications
Erasmushogeschool Brussel