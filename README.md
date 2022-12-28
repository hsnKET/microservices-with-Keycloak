# Microservices with Keycloak



1. Download Keycloak 19 from the Keycloak official website (https://www.keycloak.org/downloads).

![image](https://user-images.githubusercontent.com/94486861/209845852-db298929-7674-4dd5-87a3-fe1e8b6fb8a6.png)

2. Once downloaded, start Keycloak by running the `kc.bat start-dev` in the Keycloak installation directory.

![image](https://user-images.githubusercontent.com/94486861/209846159-c741a3de-9726-4a61-967a-5a98b4386f7a.png)

3. Once Keycloak is started, access the management interface using the URL http://localhost:8080 and click the "Admin Console" button.

![image](https://user-images.githubusercontent.com/94486861/209846289-5b05da76-1558-4440-bc2c-690ee79d652c.png)

4. Create an Admin account by following the instructions displayed on the screen.

![image](https://user-images.githubusercontent.com/94486861/209846454-b407abe5-3c0f-477a-840d-94ae70ee7c82.png)

5. Once logged in as an Admin, create a new Realm by clicking the "Add realm" button and following the instructions displayed.

![image](https://user-images.githubusercontent.com/94486861/209846573-70140e09-8c87-4c07-bf3d-13779fea0b81.png)

![image](https://user-images.githubusercontent.com/94486861/209846696-b058b0b2-5d21-43cd-a94a-46f7b43836ec.png)



6. Create a new client by clicking the "Clients" button in the "Configuration" section of the Realm, then clicking the "Create" button. Enter the client details and select "Confidential" as the client type.

![image](https://user-images.githubusercontent.com/94486861/209846775-2362f51c-2d72-4b76-a123-e930350edd11.png)

![image](https://user-images.githubusercontent.com/94486861/209847005-7823b3c6-cff0-48df-9160-add2be6f52d1.png)

![image](https://user-images.githubusercontent.com/94486861/209847439-9d65f26b-0ae8-4b86-bbb4-ee65ff682dcd.png)

7. Create users by clicking the "Users" button in the "Management" section of the Realm, then clicking the "Add user" button. Enter the user details and set a password for the user.

![image](https://user-images.githubusercontent.com/94486861/209847545-b00a8598-9d42-441f-9bc2-5be40d46c907.png)

![image](https://user-images.githubusercontent.com/94486861/209847704-8971e7df-1a84-4b6f-be58-16f15ae7d02c.png)

8. Create roles by clicking the "Roles" button in the "Management" section of the Realm, then clicking the "Add Role" button. Enter the role name and set its permissions.
Assign roles to users by selecting the user from the list of users and clicking the "Role Mappings" button. Select the roles to be assigned to the user and click "Save".

![image](https://user-images.githubusercontent.com/94486861/209847768-eab7fa4d-50a1-4fd3-b1af-fa0e1758a007.png)

![image](https://user-images.githubusercontent.com/94486861/209847828-2713b352-40b8-4a8c-8693-ef5f1db1a615.png)

### Test authentication with Postman:

Enter the URL of the API you want to test in the address bar and select "POST" as the request type.
In the body of request enter the following information: `client_id`, `username`, `password`, `grant_type`

![image](https://user-images.githubusercontent.com/94486861/209849182-dd1c3559-1c33-4b70-9323-c7561b358a71.png)





