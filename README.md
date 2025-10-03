# ATM Interface

A Java-based ATM simulation system that provides basic banking operations through a console interface.

---

## Features

- **Balance Inquiry**: Check current account balance
- **Cash Deposit**: Deposit money (Maximum: $10,000 per transaction)
- **Cash Withdrawal**: Withdraw money (Maximum: $1,000 per transaction)
- **Input Validation**: Handles invalid inputs and insufficient funds
- **Transaction Limits**: Enforces deposit and withdrawal limits
- **User-Friendly Interface**: Clear menu-driven console interface

## Object-Oriented Design

### Classes

1. **BankAccount**: Manages account data and balance operations
   - Account number and holder name
   - Balance tracking
   - Deposit and withdrawal methods

2. **ATM**: Handles user interactions and transactions
   - Menu display and navigation
   - Transaction processing
   - Error handling

---

## How to Run

1. Compile all classes:
```Copy Code
   javac ATMInterface.java
```
2. Run the program:

```Copy Code
  java ATMInterface
```
Usage Example
=====================================
      Welcome to ABC Bank ATM
=====================================
Account Holder: John Smith

Main Menu
---------
1. Check Balance
2. Deposit Cash
3. Withdraw Cash
4. Exit
Please select an option: 1

========== Balance Inquiry ==========
Account Number: ACC123456789
Account Holder: John Smith
Available Balance: $1000.00
=====================================
Transaction Limits

Deposit: Maximum $10,000 per transaction
Withdrawal: Maximum $1,000 per transaction
Minimum: All transactions must be greater than $0

---

Technologies Used

Java
Object-Oriented Programming (OOP)
Scanner for user input
Exception handling

---

About
This project was developed as Task 3 during my Virtual Internship at CodSoft.
Default Account

Account Number: ACC123456789
Account Holder: John Smith
Initial Balance: $1,000.00

