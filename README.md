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
* Java: 11

Using Eclipse, select Import Maven Project and select the top level project from the Git Clone.



Put together a small microservice that manages multiple journals via a RESTful API. Please don’t spend more than an hour and 15 minutes on this project. We’re much more interested in your approach than a polished solution. Partial solutions are welcome and expected. 
● Develop in a private repository and share the link with us (github, gitlab)
	○ give us multiple commits so we can watch the project grow
● Implement in Kotlin
● Include a README.md for setup and deployment
	○ Include sample interactions
	○ Include a quick summary describing the tools you used to exercise the API endpoints
● Make it easy to deploy and run
● RESTful interface
○ CRUD for a Journal e.g. `{ "name": "My Awesome Journal" }`
■ POST GET /journals
■ GET PUT DELETE /journals/{journal}
○ CRUD for a Journal's entries `"Hi welcome to my journal…."`
■ POST GET /journals/{journal}/entries e.g.
■ GET PUT DELETE /journals/{journal}/entries/{entry} or /entries/{entry}
● Entries are plain text
● Transient in-memory persistence is fine
● Optional (any from the following, none are required)
○ What's your evaluation of this exercise? Is it a reasonable and valuable skills test? Like it,
hate it?
○ Include a short writeup for a QA engineer to use for testing (either manually or to set up
automated testing)
○ Briefly describe how you'd accomplish this in another tech stack (Node, Laravel, AWS Lambdas,
C#/.NET Core, etc…)
○ Persist to storage via DB, etc to survive restarts
○ Simple frontend for viewing existing journals and entries
○ Surprise us
