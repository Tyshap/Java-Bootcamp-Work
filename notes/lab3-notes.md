# Banking Service Notes

## SOLID self review
- SRP: Each class was designed with one function in mind, BankService handles inputs, accounts handle their own transactions, and the main class handles the primary execution.
- OCP: Each subclass that was added did not require the old classes to be edited, in this case those subclasses being the different account types.
- LSP: By making the abstract `Account` class, w were able to store all accounts in an array instead of requiring different arrays for different accounts, allowing us to use the necessary account types where needed.
- ISP: The `printDetails` method ended up being used for implementation in the children of the `Account` class while remaining unimplemented in the `Account` class, as well as used for the `Customer` class.
- DIP: The menu in `Main` uses the `BankServices` system instead of relying on itself, allowing us to simply swap out `BankServices` instead of completely needing to rewrite the `Main` class if we want to make changes.

## BankService UML

```mermaid
classDiagram
class Printable {
<<interface>>
+printDetails()
}
class Customer {
    -customerID
    -name
    -email
    -phone
+display()
+printDetails()
}
class Account {
<<abstract>>
-accountNumber
-balance
-customer
+deposit(amount)
+withdraw(amount)
+displayAccount()*
}
class SavingsAccount {
-interestRate
+calculateInterest()
+displayAccount()
}
class CurrentAccount {
-transactionFee
+calculateCharges()
+displayAccount()
}
class BankService{
-MAX_CUSTOMERS
-MAX_ACCOUNTS
-MAX_TRANSACTIONS
-customers
-accounts
-transactions
-customerCount
-transactionCount
-accountCount
-nextTransactionNumber
-nextAccountNumber
+createCustomer()
+createSavingsAccount()
+createCurrentAccount()
+makeDeposit()
+makeWithdrawal()
+displayCustomers()
+displayAccounts()

    
}
class Main
class Transaction{
    -transactionID
    -amount
    -type
    -date
    -accountNumber
}

    Printable <|.. Customer : implemented
    Printable <|.. SavingsAccount : implemented
    Printable <|.. CurrentAccount : implemented
    Account <|-- SavingsAccount : subclass
    Account <|-- CurrentAccount : subclass
    Account --> Customer : owns
    BankService --> Customer
    BankService --> Account
    BankService --> Transaction
    Main --> BankService
```

