# Beginning SpringBoot 3


### Chapter 07 : Working with JOOQ

**springblog-jooq**: This module is a SpringBoot application demonstrating how to use JOOQ starter.

#### How to run?

If you want to use H2 in-memory db:

springblog-jooq> mvn clean verify -P h2

If you want to use MySQL db:

springblog-jooq> mvn clean verify -P mysql -Dspring.profiles.active=prod
