# PokeExam
Java Exam. Application using Spring Boot. SOAP web server with endpoint related to pokemon, data is obtained via pokeapi.co

Instructions.

Requires a database to be installed (the program was tested in PostgreSql.
Configure the following properties in application.properties with your database port and name, username and password:
spring.datasource.url=jdbc:postgresql://localhost:5432/exam
spring.datasource.username=USER
spring.datasource.password=PASS

The table creation is done automatically.

Run in Windows with:
.\mvnw.cmd spring-boot:run
Or run in Linux with:
./mvnw spring-boot:run

The wsdl is located at:
http://localhost:8080/ws/pokemon.wsdl
