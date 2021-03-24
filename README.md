Mini web application "Monitor Sensors".
The application consists of 4 forms: a login form, a table form, and forms for adding and editing sensors.
For development were used: Java, Spring Boot, Spring Security, Spring Data, Lombok, Liquibase.
There are 2 pre-installed users in the system:
1. Admin with the Administrator role
2. User with the Uaser role
Spring Security is used for authentication and authorization.
A user with the Administrator role is allowed access to all forms and all actions in the application are allowed.
A user with the Viewer role is only allowed to access the Login and Sensor Table forms. On the Sensor Table form, actions related only to viewing data are allowed, without the right to add, delete, or
change records.
The user with the Administrator role is allowed to perform the next actions:
- add a new sensor (go to form 3)
- edit the selected sensor (go to form 4)
- delete the selected sensor.

By clicking the logout button, the user logs out and is redirected to the login form.
For non-authorized users, only the Login form is available.
The data for the table is taken by means of queries from the server side (the data is stored in the database).
Data search is a text input field and a search button. The search is performed by a partial match of the entered text in any field of the record.
After the search is complete, only the appropriate records remain in the table.
When you hover over the sensor name (field Name), a hint is displayed with the full description of the sensor (field description).
