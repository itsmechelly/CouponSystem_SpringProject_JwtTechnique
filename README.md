# CouponSystem_SpringProject_JwtTechnique

# CouponSystem_SpringProject_SessionTechnique

This application is the final project I created during my software studies.<br/>
The application is a Fullstack project, it is written in Java language on the server side and in React on the client side.

### 🤔 What is the purpose of this application?
This is a coupon management system that allows companies to generate coupons as part of advertising and marketing campaigns that they run.<br/>
The system also has registered customers, the customers can purchase coupons, coupons are limited in quantity and validity, a customer is limited to one coupon of each type.<br/>
The system records the coupons purchased by each customer.<br/>
The revenue of the system is from the purchase of coupons by the customers and by the creation of new coupons by the companies.

### 💻 Access to the system is divided into three types of clients:
1. Administrator - manages the system, managing the lists of companies and the customers.<br/>
2. Company – managing a list of coupons associated with the company.<br/>
3. Customer - who buy coupons.<br/>

# The reason I created 3 versions of the server side
Since I always had a great passion and a special connection while working on the server side, during the software studying, I decided to do the server side in 3 different ways, each of them focusing on a different technological technique.

# Now, let's dive into the 3 types of projects I created

## 1️⃣ The 1st Project: Java
Writing the server side in plain old Java.<br/>
For the database I used:<br/>
-	SQL
-	JDBC
-	ConnectionPool that manage the connections queries sent to the database.<br/>

In this project I used simple login() method for authentication & authorization.<br/><br/>

Click here to see this project on Github:<br/>
https://github.com/itsmechelly/CouponSystem_JavaProject 

## 2️⃣ The 2nd Project: Spring Framework and Session Technique for Authentication & Authorization
In the second project I rewrite the core system for more recent technology - I used Java language and Spring Framework.<br/>
For the database I used:<br/>
-	Spring Hibernate JPA.<br/>

For the authentication & authorization I used the Sessions technique.<br/><br/>

Click here to see this project on Github:<br/>
https://github.com/itsmechelly/CouponSystem_SpringProject_SessionTechnique 

## 3️⃣ The 3ed Project: Spring Framework and JWT Technique for Authentication & Authorization
In the second project I rewrite the core system for more recent technology - I used Java language and Spring Framework.<br/>
For the database I used:<br/>
-	Spring Hibernate JPA.<br/>

For the authentication & authorization I used the JTW technique.<br/><br/>

👉 The current repo represent this 3rd project.<br/>
https://github.com/itsmechelly/CouponSystem_SpringProject_JwtTechnique<br/><br/>
👉 NOTE: this project is the final version and deployed to AWS cloud, click to browse the website:<br/>
LINK WILL BE ADDED SOON
<br/><br/>
👉 To login, use those details:<br/>
Admin: ➡️ e-mail: admin@admin.com password: admin<br/>
Company: ➡️ e-mail: zootAllures@company.com password: zootAllures<br/>
Customer: ➡️ e-mail: cust1@cust.com password: 1111<br/>

# And what about the Client side?
This part of the application was written using React libraries and is built as a Single Page Application (SPA).<br/>
The communication between server side and client side was done using Json and RESTful API.<br/><br/>
Click here to see this project on Github:<br/>
https://github.com/itsmechelly/CouponSystem_ReactProject<br/><br/>
👉 NOTE: this project is the final version and deployed to AWS cloud, click to browse the website:<br/>
LINK WILL BE ADDED SOON
<br/><br/>
👉 To login, use those details:<br/>
Admin: ➡️ e-mail: admin@admin.com password: admin<br/>
Company: ➡️ e-mail: zootAllures@company.com password: zootAllures<br/>
Customer: ➡️ e-mail: cust1@cust.com password: 1111<br/>

# Application Architecture – 3rd Project:
## Creating Java Beans that represent the Spring Entities in the database:
Java Beans are pure information classes that represent the information managed by the application.<br/>
Below is the diagram of the Java Beans classes:<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230069381-7185e8d2-a1f6-4db4-8c86-d5741926877c.png)

## MVC Architecture:
As we will see below, this project implements an MVC architecture.<br/>
After the user performs a request on the client side, the first layer that is activated on the server side is the controller layer.

## The first controller – LoginController – manage Authentication & Authorization:
The first controller the client encounters is the login controller.<br/>
Login Controller calls to Login Service.<br/>
The login service contains a method that checks the type of the client, then, according to the client type, generates a new Token that will be valid for 30 minutes.<br/>
This token addresses the specific service type of the client.<br/>
And then this service returns the generated token to the controller and inserts it into a new HttpHeaders object.<br/>
Then, whenever a request comes from the client endpoint, the HttpHeader requests this token. In each such request - the system will check whether the token transferred in the header is indeed compatible with the real token.<br/>
For securely transmitting the login information I used JSON Web Token (JWT) library (SignatureAlgorithm.HS256).<br/>
The token is automatically updated every 30 minutes.<br/>
This is how it looks in macro view:<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230069756-e6d30b56-b994-4f5b-8c1b-0afba8ac7847.png)
<br/>

Diagram of login class in details:<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230069846-c2294a85-6ff3-404f-882d-49d5f0b017db.png)

## Now, when the user is logged in – other controllers can be in use:
According to the client type, and after the client's first request has been made - the login, and after the client has a token that is activated behind the scenes - now, with every request the client sends - the relevant controller will be activated (as mentioned, the token and the client type are stored in the HttpHeader).<br/>
The request is passed to the Service Layer into the specific method, which in turn checks whether the token is valid.<br/>
The service layer contains an operates the business logic and then passes the request to another layer I created - Impl Layer (I created this layer to create separation in access to the Repository layer - this creates extra protection).<br/>
And finally - there is a repository Layer that is managed by Spring Hibernate JPA and it is the one that adds, updates, deletes, and manages the information stored in the database.<br/><br/>

A Facade Design Pattern is used here.<br/>
Such a design allows simple operations to be outsourced, which behind the scenes use a series of extra operations.<br/>
Because there is three classes need to use the service components, each by his client type - I defined an abstract base class – ClientService that reference to the service classes (it will first login() and then direct to the relevant service layer according to the client type).<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230069972-0276eb29-31bd-4cae-8744-9ec38ebd5c47.png)

## Building a daily job to delete expired coupons from the system (Spring Scheduling):
A basic infrastructure service named CouponExpirationDailyJob was established to clean the system from expired coupons.<br/>
The job is a process that runs in the background regularly and checks and cleans coupons once every 24 hours.<br/>
The job is executed using a Spring Scheduling that runs parallel to the system activity.<br/>
Below is the job diagram for this job activity:<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230070201-30912eb9-51db-423f-af26-c76e18ad9439.png)

## Using Custom Exceptions:
In addition to the Java exceptions, I created system-specific exceptions:<br/><br/>
![image](https://user-images.githubusercontent.com/60425986/230070265-adecebe4-7dd5-4142-9ae4-f8a9331c08e7.png)


# Endpoints
Please click the link below to browse the website:<br/>
LINK WILL BE ADDED HERE SOON<br/>
<br/><br/>
👉 Note: to login, use those details:<br/>
Admin: ➡️ e-mail: admin@admin.com password: admin<br/>
Company: ➡️ e-mail: zootAllures@company.com password: zootAllures<br/>
Customer: ➡️ e-mail: cust1@cust.com password: 1111<br/>

## Admin Controller:
👉 Note: to enter those routes you should first login, you can use those details:
e-mail: admin@admin.com password: admin

```http
admin/addCompany 
```
```http
admin/addCompany 
```
```http
/admin/updateCompany 
```
```http
/admin/deleteCompany/{companyId} 
```
```http
/admin/getOneCompanyById/{companyId} 
```
```http
/admin/getAllCompanies 
```
```http
/admin/addCustomer 
```
```http
/admin/updateCustomer 
```
```http
/admin/deleteCustomer/{customerId} 
```
```http
/admin/getOneCustomerById/{customerId} 
```
```http
/admin/getAllCustomers 
```

## Company Controller:
👉 Note: to enter those routes you should first login, you can use those details:
e-mail: zootAllures@company.com password: zootAllures

```
/company/addCompanyCoupon 
```
```http
/company/updateCompanyCoupon 
```
```http
/company/deleteCompanyCoupon 
```
```http
/company/getAllCompaniesCoupons 
```
```http
/company/getAllCouponsByCategory/{couponCategory} 
```
```http
/company/getAllCouponsUnderMaxPrice 
```
```http
/company/getCompanyDetails 
```

## Customer Controller:
👉 Note: to enter those routes you should first login, you can use those details:
e-mail: cust1@cust.com password: 1111


```http
/customer/purchaseCoupon 
```
```http
/customer/getAllCustomerCoupons 
```
```http
/customer/getAllCouponsByCategory/{couponCategory} 
```
```http
/customer/getAllCouponsUnderMaxPrice 
```
```http
/customer/getCustomerDetails 
```

# ⚒️ Tech Stack
Language & Framework: Java Language, Spring Framework
<br/>
Database: Spring Hibernate, Spring JPA (MySQL Driver), SQL, MySQL
<br/>
Authentication & Authorization: JSON Web Token (JWT) library
<br/>
Scheduling Mechanisms: Spring Scheduling
<br/>
Architecture & Design Patterns: Spring MVC Layers, Singleton Pattern, Facade Pattern, Factory Pattern
<br/>
Communication between Client side and Server side: Restful API
<br/>
Client-Side: React, JavaScript, Typescript, Bootstrap 5, HTML, CSS
<br/>


<br/>
Thanks for reading,
<br/>
Chelly 👩🏻‍💻
