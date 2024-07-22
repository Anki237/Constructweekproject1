# Cryptocurrency Wallet

![Screenshot 2024-07-22 054055](https://github.com/user-attachments/assets/4632d32c-79dc-4d01-b109-b02564c66868)

## Introduction
Designing a complete JSON REST API for a crypto wallet is a comprehensive task that requires careful consideration of various functionalities and security measures. Here, app are providing us with an overview of the API endpoints and payloads for some essential operations.

Here we going to validate the response code and response body of the respose we received after sending the request to the server.

## Project Type
Backend (API) Testing

## Architecture
The two-tier is based on Client Server architecture. The two-tier architecture is like client server application. The direct communication takes place between client and server. There is no intermediate between client and server. Because of tight coupling a 2 tiered application will run faster.
When using an application to access the DBMS, the Two-tier DBMS Architecture is used. Through the use of API calls, client-side applications can connect directly to the database server, separating the application from the Database in terms of functionality, programming, and design.

<img width="527" alt="image" src="https://github.com/user-attachments/assets/e30bf7dc-96b6-4ba9-8859-d43846a4fea4">


## Directory Structure
Constructweekproject1/ ├─apicypressproject /├─ Cypress/ ├─ Integration/ ├─ Test/ ├─ Cryptocurrencywallet/

## Features
Operations performed in the API.

- POST Method
- GET Method

## Installation & Getting started
Detailed instructions on how to install, configure, and get the project running.

Install the Cypress Using Command
```
npm -i init - To initialize node server in vscode.
npm install cypress --save-dev -To install cypress.
```

## Usage
Create a folder. Open a command prompt navigate to your folder. Paste this command(You have to install git first)

git clone https://github.com/Anki237/Constructweekproject1.git

It will download this project 
and run by giving command .

```bash
npx cypress open
```

 ##Screenshots

 ![Screenshot 2024-07-22 064718](https://github.com/user-attachments/assets/aff74a24-99f2-49be-aa3b-8f21cfb77c22)
 <img width="447" alt="image" src="https://github.com/user-attachments/assets/efc93a7c-e301-4c75-8af2-03861c85b18a">
 <img width="649" alt="image" src="https://github.com/user-attachments/assets/7e176042-de4b-4b41-a173-3cc68874e73d">
 <img width="197" alt="image" src="https://github.com/user-attachments/assets/5818f538-65e1-4f3e-8d28-4777414c957f">
 <img width="230" alt="image" src="https://github.com/user-attachments/assets/6c0f9670-b8b4-46e4-97af-75d33afa9ceb">





## Credentials
Opensource free tool so no credentials required.

## Links to GET API
https://app.beeceptor.com/mock-server/crypto-wallet-server


## API Base URL
https://crypto-wallet-server.mock.beeceptor.com


## API Endpoints

POST /api/v1/register - Register a user, and create his/her wallet

POST /api/v1/login - Login the user and generate a session token

GET /api/v1/balance - Retrieve the wallet balance

GET /api/v1/transactions - List all the transactions done by the user

POST /api/v1/transactions - Transfer 5 ETH to a recipient

POST /api/v1/transaction_fee - Calculate transaction fees and return estimated cost

GET /api/v1/exchange_rates - Get an object with all available currency exchange rates



## Technology Stack
JavaScript

HTML

CSS

Node.js

## Version Control and Testing tools used:

Git

GitHub

Cypress

Visual Studio Code

## Operating System and browsers used:

Windows

Edge

Firefox

## Feedback

For any feedback, please reach out to me at ankitaverma14sept@gmail.com
