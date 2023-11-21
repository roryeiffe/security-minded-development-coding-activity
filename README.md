# Security-Minded Development with Gen AI

### Contributors:

Rory Eiffe

### Prerequisites

1. Basic Understanding of a Gen AI tool (Codeium, CoPilot, etc.)
2. Basic Security Knowledge
3. Basic Java/JDBC Knowledge

### Technologies Used
1. Java
1. JDBC
1. H2
1. HTTP Server

### Time
30 Minutes

### Applied Skills

1. Learn how to use AI tools to build an application that adheres to security best practices
2. Identify security flaws in an application that is built using AI

### Steps

1. Inspect the code base and understand what it is trying to do.
1. Use GenAI to implement the methods with TODO statements. Most methods are annotated with JavaDocs
1. Ensure that the generated code adheres to security best practices. Specific vulnerabilities are listed in the requirements section

### Requirements

1. All methods with TODO statements are filled out correctly.
2. The application is free from obvious security flaws such as
    1. SQL Injection
    1. Sensitive data, such as passwords, being exposed in response body
    1. Weak passwords, such as short passwords or passwords with no numbers/symbols


### Stretch Goals 

1. Implement hashing for passwords so plain-text passwords are not stored in database.

### Discussion & FAQ
1. What changes did you need to make to the generated code to ensure the application is secure?
1. What security features did the AI generate on its own?
1. In general, how successful was the AI tool at generating secure code?