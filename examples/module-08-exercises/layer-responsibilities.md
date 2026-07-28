# Layer Responsibility

| Task                                | Layer        |
|-------------------------------------|--------------|
| Accept future create-customer input | `Controller` |
| Reject blank customer name          | `Service`    |
| Find customer by ID                 | `Repository` |
| Represent customer ID/name/status   | `Entity`     |
| Represent create request fields     | `dto`        |
| Define customer-not-found failure   | `Exceoption` |
| Wire application objects later      | `Config`     |

## Controller maps request
→ Service validates/orchestrates\
→ Repository saves/finds\
→ Service returns result\
→ Controller maps response

## Explanation

Creating these kinds of boundaries are useful for debugging and optimization. Whenever you read stack traces, you can clearly see where errors are raised or where performance may be suffering.\
It also keeps repositories organized and keeps documentation and ownership clear.