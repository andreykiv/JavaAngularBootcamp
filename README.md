# Activities Unit 32 JavaAngularBootcamp

#### 1. Description
```
In the first exercice the task was to make a get requests to an external API via AJAX and handle the output with JQuery.

The task of the second exercice was to create an API REST (using Spring Tool Suite) and make the complete CRUD requests to the
embedded database (H2). It was also important to configure CORS in the server side in order to CRUD requests to work. 

Some complications that were met when doing those exerices: 
1. When sending PUT and POST to the server, Spring couldn't 'understand' the format of 
a content Type 'x-www-form-urlencoded'. In order to make it work, '@RequestBody' 
from within controller package was deleted. 
2. When configuring CORS, applyPermitDefaultValues() method just allows a 'simple' "GET, HEAD and POST"
methods to be accepted by requests. In order for other methods ("DELETE, PUT") 
to work it was decided to add it manually to a new CorsConfiguration Object.

List of installed Maven dependencies:
- H2 Database 
- Spring Boot DevTools
- Spring Data JPA
- Spring Web
- JWT
- Spring Boot Starter Security

As in the previous unit, Visual Studio Code editor was used for such purpose. Plugins that were 
installed to make a life a little bit easier:

- vscode-icons
- Beautify
- markdown-preview
- live server
```

#### 2. Tools used to run activities
```
IDE: Spring Tool Suite 4  Version: 4.9.0.RELEASE
JRE System Library: jdk.1.8.0_281  
Maven: version 3.6.3 
Postman: version 8.0.7
Visual Studio Code (VSC): 1.53.2
Google Chrome: V. 89.0.4389.82 (64 bits)
```
#### 3. Useful Links

[CDN links](https://cdnjs.com/)

[VSC download link](https://code.visualstudio.com/download)
