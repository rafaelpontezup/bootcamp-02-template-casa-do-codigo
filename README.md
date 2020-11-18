# Casa do codigo

## Run
Building and running with Docker Compose locally
```
$> docker-compose up --build
```

## Usage
The following will demonstrate the usage of the HTTP endpoints and example responses.

- Registration of a new author:
```
$> curl localhost:8080/authors -i -XPOST \
  -H 'Content-Type: application/json' \
  -d '{"name":"Venkat Subramaniam","email":"venkats@agiledeveloper.com","description":"Venkat Subramaniam is an award-winning author."}'

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 18 Nov 2020 08:55:06 GMT

{"id":1,"name":"Venkat Subramaniam","email":"venkats@agiledeveloper.com","description":"Venkat Subramaniam is an award-winning author.","createdAt":"2020-11-18T08:55:06.021131Z"}
``` 

- Registration of a category:
```
$> curl localhost:8080/categories -i -XPOST \
  -H 'Content-Type: application/json' \
  -d '{"name": "Computers & Technology"}'

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 18 Nov 2020 09:11:57 GMT

{"id":1,"name":"Computers & Technology"}
``` 
