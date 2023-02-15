# Hello! Welcome to the guidelines to my person API.

## All you're going to need in order to run this app is:

 - [Docker](https://docs.docker.com/engine/install/ubuntu/)
 - [Docker Compose](https://docs.docker.com/compose/install/)

## Setting up
 - After installing docker and docker-compose, you have to clone this repo
 - Then you go to this repo clone directory and to run the following command in your terminal:
```
docker-compose up
```
 - Wait a little while the images buildings are complete and the containers running

## Endpoints

 - GET - http://localhost:8080/person - to list all people
 - POST - http://localhost:8080/person - to create a person
```
The request body should look like this:
{
    "name": "Name",
    "birthDay": "2000-10-01",
    "addressList": [
        {
            "street": "street1",
            "zipCode": 12345,
            "number": 12,
            "city": "City"
        }, 
        {
            "street": "street2",
            "zipCode": 12346,
            "number": 13,
            "city": "City"            
        }
    ]
}
```
 - GET - http://localhost:8080/person/{id} - to get a person by id
 - PUT - http://localhost:8080/person/{id} - to edit a person by id
```
The request body should look like this:
{
    "name": "Name2",
    "birthDay": "2000-10-01",
    "addressList": [
        {
            "street": "street1",
            "zipCode": 12345,
            "number": 12,
            "city": "City"
        },
        {
            "street": "street2",
            "zipCode": 12346,
            "number": 13,
            "city": "City"
        }
    ]
}
```
 - POST - http://localhost:8080/person/{id} - to insert a new address to a person by id
```
The request body should look like this:
{
    "street": "street3",
    "zipCode": 12345,
    "number": 12,
    "city": "City"
}
```
 - GET - http://localhost:8080/address/{id} - to get the address list of a person by id
 - GET - http://localhost:8080/address/main/{id} - to get the main address of a person by id