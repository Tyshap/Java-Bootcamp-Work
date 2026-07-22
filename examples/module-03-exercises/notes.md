# Banking domain notes

| Entity | Identity | Important attributes                            | Main responsibility |
| ------ | -------- |-------------------------------------------------| ------------------- |
| Customer | customerId | name, email, phone, PIN                         | Maintain customer profile |
| Account | accountNumber | owner, balance, accountType, transactionHistory | Protect balance and perform deposits/withdrawals |
| Transaction | transactionId | account, type, amount, timestamp                | Record one account operation |

## Relationships

- One Customer can own zero or more Accounts.
- One Account belongs to exactly one Customer.
- One Account can have many Transactions.
- One Transaction belongs to exactly one Account.

## Rules

- An account balance cannot be changed directly from outside Account.
- A deposit amount must be positive.
- A withdrawal cannot exceed the allowed balance.

## Explanation

An account should be the one to verify withdrawals since outside accounts are not allowed\
to have an impact on the account's transactions. Putting the withdrawals in main would allow\
for the opportunity for an outside account to affect those withdrawals.

## SRP Spot Check

By splitting the method into multiple methods that have a single responsibility,\
it allows for easier changes for if you need to change a formula, or if you want to reuse\
those specific responsibilities elsewhere. For example here, if we wanted to reuse
the interest calculation elsewhere where we wouldn't want to print that calculation immediately, or\
if we wanted to change the formatting of how the interest calculation is being printed to the console.

The `Main` function will run the banking menu, the `BankService` will handle the transactions, and\
each individual account domain will focus on holding and protecting its personal data.

## SOLID Foundations

- OCP is the idea that classes should be extended upon, not modified for every use case.
- LSP is meant to say that subclasses should fit into their parent classes without unexpected behaviors.
- ISP is meant to seperate functionality so that you can clearly define what classes have which functionalities
- DIP is meant so that classes do not need to rely on the functionality of another class so when you change the functionality of the class that it would have relied upon, you don't need to then also change how the original class works

**S**ingle Responsibility\
**O**pen/Closed\
**L**iskov Substitution\
**I**nterface Segregation\
**D**ependency Inversion
