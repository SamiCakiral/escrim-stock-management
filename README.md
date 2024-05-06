# EscrimWebApp

## Description
EscrimWebApp is a comprehensive web application designed to facilitate the management of medical stock and personnel for the deployable hospital project, ESCRIM (Rapid Medical Intervention Civil Security Element).

The ESCRIM project aims to enhance crisis intervention capabilities in disaster situations by leveraging technology and innovation. The EscrimWebApp plays a pivotal role in this initiative by providing a user-friendly interface for managing medical resources, personnel, and logistics.

## Features
- **Stock Management**: Efficiently manage medical stock, including inventory tracking, expiration dates, and restocking.
  
- **User Management**: Facilitate user roles and permissions, ensuring secure access to application features based on user roles (e.g., doctors, military personnel).

- **Dashboard and Analytics**: Visualize operational metrics and key performance indicators (KPIs) for informed decision-making.

- **Database Integration**: Seamless integration with SQL databases to store and retrieve critical data.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/SamiCakiral/escrimwebapp.git

2. Build the project using Maven:
    ```bash
    mvn clean install

3. Deploy the WAR file to a servlet container (e.g., Apache Tomcat).

WARNING: Before running the code, ensure to update line 54 of DAOManager.java with the correct database path associated with your local environment.

## Usage
1. Launch the web application by deploying the WAR file to your servlet container.
2. Access the application in your web browser.

## Project Architecture
The EscrimWebApp follows a structured architecture to meet the project's requirements:

- Database Schema: Utilizes SQL tables to manage patient records, medical equipment, personnel details, and mission data.
- Model-View-Controller (MVC): Implements the MVC architecture, dividing the application into distinct layers for model (data handling), view (user interface), and controller (application logic).
- Package Diagram: Reflects the MVC structure with specialized packages for personnel management, medical resources, and user interface components.
- Class Diagram: Illustrates the relationships and functionalities of various classes, including DAOManagers for database interaction, patient management classes, and material handling classes.
- Use Case and Kaos Models: Provides a visual representation of system interactions, user roles, and project requirements.
Contributing
Contributions to EscrimWebApp are welcome! Feel free to fork the repository, make changes, and submit pull requests.

## Contributing
Contributions to EscrimWebApp are welcome! Feel free to fork the repository, make changes, and submit pull requests.

## License
This project is licensed under the MIT License.

For detailed information on setting up the application and understanding its architecture, refer to the project documentation and diagrams provided.