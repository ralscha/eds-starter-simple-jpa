# eds-starter65-simple-jpa
Starter application with Ext JS 6.5 Modern Toolkit and Spring Boot

Run the application your local machine

Prerequisite
* Install Sencha CMD: https://www.sencha.com/products/extjs/cmd-download/
* Download Ext JS 6.5 and unzip it into any folder (that's the folder you specify in step 4)
* Make sure that the Ext JS version in ```eds-starter65-simple-jpa/workspace.json``` matches the downloaded Ext JS version

1. Clone the repository
2. Open Command Prompt / Terminal / Shell
3. ```cd eds-starter65-simple-jpa/client```
4. ```sencha app install --framework=/path/to/extjs/```
5. ```sencha app build```
6. ```cd ..```
7. ```./mvnw spring-boot:run -Dspring.profiles.active="development"```


