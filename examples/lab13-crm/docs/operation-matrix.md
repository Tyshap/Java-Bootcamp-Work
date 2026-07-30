|Operation|Purpose|Key inputs|Key Outputs|
|----|---|---|---|
|CreateCustomer|Register a new CRM customer | fullName, email, phone?, status?|customer (with ID)|
|UpdateCustomer|Change mutable fields / status | customerID, optional fields | customer|
|GetCustomer | Fetch one customer by ID | customerId|customer|