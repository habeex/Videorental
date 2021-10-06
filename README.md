# Video Rental Assessment
System for managing the video rental services.

## Running the tests
./gradlew clean test

## API Reference
API reference documentation is available at 
https://videorental.herokuapp.com/swagger-ui.html#/

### Example API Calls

### User Management
## Add new user 
```
{
  "age": 0,
  "email": "string",
  "gender": "Male",
  "name": "string"
}
```

## GET Search for users
{base_url}/user?name={name}&page={current_page}&limit={limit_per_page}

## GET find user by email
{base_url}/user/{email}

### Video Management

## POST Add new user 
genre{Action, Drama, Romance, Comedy, Horror} 
type{Regular, Children, NewRelease}
```
{
  "age": 0,
  "description": "string",
  "genre": "Action",
  "rate": 0,
  "releasedYear": 0,
  "title": "string",
  "type": "Regular"
}
```

### Price Management
{base_url}/price/user/{userId}/video/{videoId}?rentDays={number_of_rent_days}

Visit api reference for more info

## Built With
* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org) - Build tool