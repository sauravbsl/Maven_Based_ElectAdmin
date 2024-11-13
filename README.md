Election Commission CRUD Application - README

Project Overview

This project is a Java-based CRUD (Create, Read, Update, Delete) application that manages candidate information for the Election Commission of India. It uses a MySQL database to store and manage data related to candidates, such as their ID, name, assembly, party name, state name, age, and gender. The application is built using Java with JDBC for database interaction and follows an MVC (Model-View-Controller) design pattern.

Project Structure

The project is organized into the following packages:

com.entity: Contains the Candidates class, which represents the candidate entity.

com.dao: Contains the Candidatesdao class responsible for database operations.

com.service: Contains the CandidatesService class, which serves as a service layer between the DAO and the controller.

com.controller: Contains the Candidatescontroller class that acts as a bridge between the client and the service.

com.client: Contains the Candidatesclient class, which is the main class for user interaction.

utility: Contains utility classes such as DBConnectionUtil for establishing database connections.

Key Features

Display All Candidates: Lists all candidates from the database.

Add New Candidate: Allows users to insert new candidate details into the database.

Update Candidate Details: Enables updating an existing candidate's information.

Remove Candidate: Provides functionality to delete a candidate by name.

Technologies Used

Java: Core programming language used.

JDBC: Java Database Connectivity for database operations.

MySQL: Database management system.

Scanner: Used for user input in the client class.

Prerequisites

Java Development Kit (JDK) 8 or higher

MySQL Database

IDE (e.g., Eclipse, IntelliJ IDEA)

Installation and Setup

Clone the Repository:

git clone https://github.com/your-repository/election-crud-app.git

Set Up MySQL Database:

Create a database named election.

Run the following SQL script to create the candidates table:

CREATE TABLE candidates (
    id INT PRIMARY KEY,
    names VARCHAR(100),
    assembly VARCHAR(100),
    partyname VARCHAR(100),
    statename VARCHAR(100),
    age INT,
    gender VARCHAR(10)
);

Configure Database Credentials:

Update DBConnectionUtil class with your database URL, username, and password.

How to Run the Application

Compile the project:
Ensure all the source files are compiled using your IDE or the following command:

javac -d bin src/com/**/*.java

Run the Main Class:
Execute the Candidatesclient class from your IDE or command line:

java -cp bin com.client.Candidatesclient

User Guide

Main Menu Options

1. Show All Candidates: Displays all candidates with their details.

2. Insert New Candidate: Prompts for candidate details and adds the record to the database.

3. Update Candidate Details: Prompts for updated details for an existing candidate and applies changes.

4. Remove Candidate: Deletes a candidate by their name.

5. Exit: Closes the application.

Sample Interaction

Console Output:

!!!Welcome to our System!!!
This is our menu
1. Show All Candidates
2. Insert New Candidate
3. Update Candidate From System
4. Remove Candidate Into System
5. Exit
Enter your choice: 2
Enter Candidate Details:
ID: 1
Name: Abhijit Bichkule
Assembly: Baramati
PartyName: Independent
State Name: Maharastra
Age: 45
Gender: Male
Insertion Successful.

Error Handling

Exceptions are caught and printed in the Candidatesdao methods to ensure the program doesn't crash during database operations.

User inputs are checked for validity.


