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

- Create a new book:
```
$> curl localhost:8080/books -i -XPOST \
  -H 'Content-Type: application/json' \
  -d '{"title":"Programming Kotlin","abstract":"Lorem ipsum dolor sit amet.","summary":"Cras quis cursus magna. Duis pretium placerat libero, id feugiat.","price":39.74,"pages":462,"isbn":"978-1680506358","publishedAt":"2021-10-01","categoryId":1,"authorId":1}'

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 18 Nov 2020 22:44:58 GMT

{"id":1,"title":"Programming Kotlin","abstract":"Lorem ipsum dolor sit amet.","summary":"Cras quis cursus magna. Duis pretium placerat libero, id feugiat.","price":39.74,"pages":462,"isbn":"978-1680506358","publishedAt":"2021-10-01","category":{"id":1,"name":"Computers & Technology"},"author":{"id":1,"name":"Venkat Subramaniam","email":"venkats@agiledeveloper.com","description":"Venkat Subramaniam is an award-winning author.","createdAt":"2020-11-18T22:44:30.693565Z"}}
``` 

- Display list of books to make it easier to know the id:
```
$> curl localhost:8080/books -i

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 19 Nov 2020 00:48:18 GMT

[{"id":1,"title":"Programming Kotlin"}]
``` 

- Display a book's detail page:
```
$> curl localhost:8080/books/1 -i

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 19 Nov 2020 00:52:33 GMT

{"title":"Programming Kotlin","abstract":"Lorem ipsum dolor sit amet.","summary":"Cras quis cursus magna. Duis pretium placerat libero, id feugiat.","price":39.74,"pages":462,"isbn":"978-1680506358","publishedAt":"2021-10-01","author":{"name":"Venkat Subramaniam","description":"Venkat Subramaniam is an award-winning author."}}
``` 

- Create a new country:
```
$> curl localhost:8080/countries -i -XPOST \
  -H 'Content-Type: application/json' \
  -d '{"name":"USA"}'

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 19 Nov 2020 03:23:10 GMT

{"id":1,"name":"USA"}
``` 
