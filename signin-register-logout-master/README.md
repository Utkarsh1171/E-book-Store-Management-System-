# signin-register-logout
A basic spring boot app that demonstrates login, registration, email verification, and logout capabilities by using spring security.

To establish database connection:
- You can use dbTemplate.properties file in resources directory.
- you will just need to set your mysql username and password.
- Hibernate will automatically create whole database schema. (hibernate.hbm2ddl.auto = update)
- After setting values, you will also need to change the name of the file from dbTemplates.properties to db.properties, or you can change it in DatabaseConfig.java