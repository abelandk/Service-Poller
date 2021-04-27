# Service Poller

This is a Web Application used to store URLs to perform a periodical polling.
### Actions
  *     User Can Add a URL to POLL
  *     User Can Delete a URL
### Auto Refresh
  *     Services(URLs) stored in the database are refreshed 
        every 10mins for the latest RESPONSE
### Sanity Check
  *     When a user Add URLs, the entry is checked if the text
        fulfills the universal URL requirements. 
##  Technology
  * Spring Boot
  * MySql
  * Maven
## Build
  * Create the database using the sql in **database/kryDatabase.sql**
  * Build the project using **mvnw spring-boot:run**
  * Browse http://localhost:8090/