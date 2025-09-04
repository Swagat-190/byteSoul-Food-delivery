# ByteSoul Food Delivery Microservices

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

**Author:** Swagat Mohapatra  
**GitHub:** [https://github.com/Swagat-190/byteSoul-Food-delivery](https://github.com/Swagat-190/byteSoul-Food-delivery)  

---

## Project Overview
ByteSoul Food Delivery is a **microservices-based food delivery application**.  
The system consists of multiple microservices:

| Microservice       | Description                                         |
|-------------------|-----------------------------------------------------|
| MenuService        | Manages restaurant menus and menu items            |
| CartService        | Manages user carts and cart items                  |
| OrderService       | Handles orders, order tracking, and status         |
| PaymentService     | Handles payment processing and transactions        |
| RestaurantService  | Manages restaurant data and registration           |
| UserService        | Manages user registration and authentication      |

---

## Project Structure
ByteSoul-FoodDelivery/
├─ MenuService/
├─ CartService/
├─ OrderService/
├─ PaymentService/
├─ RestaurantService/
├─ UserService/
└─ README.md



## Setup Instructions

1. **Clone the repository**
```bash
git clone https://github.com/Swagat-190/byteSoul-Food-delivery.git
cd ByteSoul-Food-delivery
Navigate to a microservice


cd MenuService/MenuService
Build the project

bash

./mvnw clean package      # Linux/macOS
mvn clean package         # Windows
Run the service

bash

java -jar target/MenuService-0.0.1-SNAPSHOT.jar
Repeat for other microservices.

Deployment (Render)
Repository URL: https://github.com/Swagat-190/byteSoul-Food-delivery

Source Directory: Path to microservice folder containing pom.xml (e.g., MenuService - Copy/MenuService)

Build Command: ./mvnw clean package

Start Command: java -jar target/MenuService-0.0.1-SNAPSHOT.jar

Ensure mvnw has executable permissions for Linux deployment.

APIs
Each microservice exposes REST APIs. Example endpoints for MenuService:

Endpoint	Method	Description
/menus	GET	Get all menu items
/menus	POST	Add a new menu item
/menus/{id}	PUT	Update a menu item
/menus/{id}	DELETE	Delete a menu item

Other services have similar endpoints (CartService, OrderService, etc.).

Contributing
Fork the repository

Create a branch: git checkout -b feature/YourFeature

Commit changes: git commit -m "Add some feature"

Push: git push origin feature/YourFeature

Create a pull request

License
MIT License



