# RestaurantAppRepo
RestaurantApp is a simple backend application for restaurant management.

STEPS TO RUN THIS PROJECT.

Importing the project using eclipse IDE.
Go to file select import then select project from git.
select clone uri copy and paste https://github.com/Raghavendram31289/RestaurantAppRepo.git then select next and finish.
Once the project set up is ready
go to file application.properties change the port number in which you want project to be run.
change the mysql database access username and password.
Start mysql server.
create 'restaurant' database since same name is given in jdbc url of application.properties
go to project in eclipse right click on pom.xml and select runas maven install.
now simply run the project by right click on RestaurantApp.java and say run as java application.




Testing the api using POSTMAN.
Note: here application port number is 3000 however you can  change it to any port by refering above.
First create categories by using the post method.
url:localhost:3000/category

POST BODY IN JSON

{
	"categoryId": "andhra123",

	"categoryName": "andhra"

}

Get request of category by providing categoryid as parameter

url:localhost:3000/category/andhra123

returns all category details of category in JSON

{
	"categoryId": "andhra123",

	"categoryName": "andhra"

}

Post request of restaurant 
url:localhost:3000/restaurant

POST body in JSON
{
	"restaurantId": "restaurant123",

	"restaurantName": "andhra",
	"address": "hyderabad",
	
	"category": {
	"categoryId": "andhra123"
}
}

get request of restaurant by giving category id as parameter
url:localhost:3000/restaurant/andhra123
returns all restaurants under the category andhra123

{
    "restaurantId": "restaurant123",
    "restaurantName": "andhra",
    "address": "hyderabad",
    "category": {
        "categoryId": "andhra123",
        "categoryName": "andhra"
    }
}























