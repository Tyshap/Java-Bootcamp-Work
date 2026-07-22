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

## Explenation

An account should be the one to verify withdrawls since outside accounts are not allowed\
to have an impact on the account's transactions. Putting the withdrawls in main would allow\
for the opportunity for an outside account to affect those withdrawls.