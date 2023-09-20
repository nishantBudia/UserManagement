# User Management Application
This SpringBoot application maintains a list of users with unique user id.

***

## Framework and Languages 
* Java Platform 8
* JDK 20
* Maven 
* SpringBoot starter web - ver. 1.3.1

## Data Flow
This section outlines implementation of the Components.
## User 
### Mapping
> /user
1. ### Controller
    The REST Controller is implemented in the Controller.java class. It contains definitions for the following API.

   | Type   | Mapping           | Data Input    | Service Method                    |
   |--------|-------------------|---------------|-----------------------------------|
   | POST   | /addUser          | RequestBody   | String  addUser( User user)       |
   | GET    | /getAllUser       | -             | HashMap<Long, User>  getAllUser() |
   | GET    | /getUser/{userId} | PathVariable  | User  getUser(Long userId)        |
   | PUT    | /UpdateUserInfo   | RequestBody   | String  updateUserInfo(User user) |
   | DELETE | /DeleteUser       | RequestParams | String  deleteUser(Long id)       |
    
2. ### Services

  * >String  addUser( User user)

    Creates a unique id for the user added through the request body and Adds them to the Database.

  * >HashMap<Long, User>  getAllUser()

    Returns a list of all users with their id.

  * >User  getUser(Long userId)

    Returns the object for the user with the particular user id.

  * >String  updateUserInfo(User user)

    Updates the User info according to the message body. All null values are ignored.

  * >String  deleteUser(Long id)

    Deletes User with the id in Request Parameters of the request.

## Visitor Count App
### Mapping
> api/v1/visitor-count-app
1. ### Controller
   The REST Controller is implemented in the Controller.java class. It contains definitions for the following API.

   | Type | Mapping                   | Data Input   | Service Method                  |
   |------|---------------------------|--------------|---------------------------------|
   | GET  | /count                    | -            | String getHitCount()            |
   | GET  | /userId/{id}/count        | PathVariable | String getUserHitCount(Long id) |
   | PUT  | /count_update/userId/{id} | PathVariable | void hit(String url, Long id)   |

2. ### Services

* >String getHitCount()

  Gets the total hit count for all endpoints that update.

* >String getUserHitCount(Long id)

  Gets the count and url of all hits for a particular user.

* >void hit(String url, Long id)

  Hits an url with a specific user.
## Repository
    Holds the HashMap and gives access to it using a getter
## DataBase Design
    The Database is essentially just a HashMap and gets destroyed when the program stops execution.
## Data Structure Used
A HashMap is used as the data structure to store user data since searching is trivialized.
Since all ids are unique, The Map is able to store ids and return User Objects as needed
  
  
    



