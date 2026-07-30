Lab 24 maps these ideas to Spring-WS faults—do not implement endpoints now.

| # | Confirm | Your notes |
| - | ------- | ------- |
| 1 | Namespace URI published | Pass |
| 2 | WSDL location placeholder documented | Pass |
| 3 | Three operations named and described | Pass |
| 4 | Sample success envelopes for CUS-1001 / CUS-1002 | Pass |
| 5 | Fault examples for not-found and validation | Pass |
| 6 | Correlation ID convention (`lab-request-001` style) | Pass  |
| 7 | Explicit note: implementation arrives in Lab 24 | Pass  |
| 8 | Optional: screenshot of VS Code XSD/WSDL outline |  Fail |

## Failure Evidence

- The broken Schema path error already existed in my IDE and I had asked about it, was told to simply ignore it for now but pressed the ignore before I could capture the error. Fetch external resource can be a valid solution but can fail.
- Creating a customer with an empty ID is possible which could lead to trouble down the line, so a well formatted XML file doesn't necessarily mean that it's ready for business implementation
- createCustomer is a bit risky for retries since duplicates can exists, however read is safe since you are simply pulling data.
- Finding soapAction was pretty simple since they are all held in the same Body.