# Description
The mayor of Gaithersburg in Maryland would like to know on the species, the number of pets by 
species and the total number of pet in his city. To do so, he has met professional developers to buid an application that will be used
to collect the data. He has instructed a group of 10 people by zipcode to conduct the survey.

Using Spring Boot, create a simple API for creating and managing items. The items can be whatever you want (i.e. Collectibles, Animals, Employees, Video Games, Shoes, Clothing, etc). Your goal will be to build an API that allows you to store these items and track them as needed.

## Requirements
- Build the application using at least Java 17 and Spring Boot 3

- All interactions between a User and the API should happen via HTTP Requests. Using a tool like Postman will allow you to set up these requests.

- All data should be stored in a SQL Database, using an in-memory H2 database will be the easiest way to tackle this problem, though a PostgreSQL database would be ideal. Remember that we're going for persistence with a Database, so we'd likely want to either use a file for H2 or just use a PostgreSQL Database as is

    - As a user, I can create a new Item
    - As a user, I can view all Items
    - As a user, I can create an account to hold my Items
    - As a user, I can login to my account (which is stored in the database)
