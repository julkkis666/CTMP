# CTMP

To run the program you can for example load https://github.com/julkkis666/CTMP into your intellij IDEA and run the 
Main method from src/main/java/main/Main.
If you perfer using Eclipse, instructions are similar. just import project from git using the link.

Program was written in Java version 11.

Program will read prospects.txt from src/main/resources/ by default but with launch arguments should be able to read
any similar file or an edited set of data with at least two names for customers in first field seperated by comma and encapsulated with "person1,person2".

if header's 5th column in file is changed to anything other than "Years", it is assumed that following timestep is months, thus number of payments will be 12x less. 

Program calculates the following mortage formula:

E = Fixed monthly payment

b = Interest on a monthly basis

U = Total loan

p = Number of payments

E = U[b(1 + b)^p]/[(1 + b)^p - 1]
