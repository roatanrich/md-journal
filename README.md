# Mission Data Coding Exercise

Start with [Spring Initializr](https://start.spring.io/)
* * Maven * for Project
* * Kotlin * for Language
* * 3.0.2 * for Spring Boot Version
* Dependencies


```bash
Rest Repositories
Spring Data JPA
Junit
HyperSQL Database
```

* Group: com.missiondata
* Artifact: journal
* Name: journal
* Description: REST Api for Journal project
* Packaging: Jar
* Java: 17

#Loading the Project

Using Eclipse, select Import Maven Project and select the top level project folder from the Git Clone

#Building the Project

From within the project window in Eclipse, right click on the project and select Run As | Maven Install

# Sample JSON

Use the following JSON sample for testing APIs in Insomnia or Postman

## Journal JSON

```bash
{
  id: 0,
  title: "My trip to France"
}
```

## Entry JSON

```bash
{
  id: 0,
  journalId: 0
  comments: "The Eiffel tower was the highlight"
}
```

## List of Entries JSON

```bash
[
 {
  id: 0,
  journalId: 0
  comments: "The Eiffel tower was the highlight"
 },
 {
  id: 1,
  journalId: 0
  comments: "The Metro System was very clean"
 },
 {
  id: 2,
  journalId: 0
  comments: "Dinner was fantastic"
 }  
]
```

#API Specification

```bash
Journal
* GET - http://localhost/api/journals/{journalId}
* GET (All) - http://localhost/api/journals
* POST - http://localhost/api/journals
* PATCH - http://localhost/api/journals
* PUT - http://localhost/api/journals
* DELETE - http://localhost/api/journals/{journalId}

Entry
* GET - http://localhost/api/journals/{journalId}/entries/{entryId}
* GET (All) - http://localhost/api/journals/{journalId}/entries
* POST - http://localhost/api/journals/{journalId}/entries
* PATCH - http://localhost/api/journals/{journalId}/entries
* PUT - http://localhost/api/journals/{journalId}/entries
* DELETE - http://localhost/api/journals/{journalId}/entries/{entryId}

```
