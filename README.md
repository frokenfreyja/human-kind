# HUMAN-KIND
Final year project (TÖL261L) in Computer Science at the University of Iceland.

## About
This web application allows its users to create an account as either a volunteer or an organization. Users can browse through the site's job ads based on interest, location or organization and finally apply for volunteer job openings. Organizations can post job ads and accept (or reject) applicants. 
<br/>
Making it easier for organizations to recruit volunteers and inspire non-volunteers to volunteer. 

## Authors
- Arnar Steinn Ólafsson, arnarsteinn95@gmail.com
- Freyja Sigurgísladóttir, freyjasigur@gmail.com

## How do I get this ?
Your IDE ([IntelliJ](https://www.jetbrains.com/idea/), [Eclipse](https://eclipse.org/), [Spring Tool Suit](https://spring.io/tools)) should be able to clone a project from Github.
It should be easy to find information regarding how to do that for your chosen IDE.

## How do I run this ?
To run the project locally you have to have a PostgreSQL server running on your computer. If you don't have it already installed on your computer you can download it [here](https://www.postgresql.org/download).
<br/>
When the download has finished follow the instructions to setup postgreSQL and create an account. After setup, add the URL to your database and its name and password in the application.properties file in the project.
<br/>
This project is setup using [Maven](https://maven.apache.org/what-is-maven.html) as a dependency manager, so if your IDE does not manage that, or you don't have it installed you can look [here](https://maven.apache.org/install.html) for further information.
When all the dependencies are downloaded, you can run the project by running the ``main()`` method in the class ``Application`` and then enter [localhost:8080](http://localhost:8080) into the address bar of your favorite web browser.
