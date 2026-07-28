# Maven Layout notes

| File                                       | Destination                       |
|--------------------------------------------|-----------------------------------|
| `Customer.java`                            | `src/com/java/com/northstar/crm`  |
| `CustomerServiceTest.java`                 | `src/test/java/com/northstar/crm` |
| `application.properties`                   | ` src/main/ressouces`             |
| `sample-customers.json` used only by tests | `src/test/resources`              |
| `CODING-STANDARDS.md`                      | `docs`                            |
| `Customer.class`                           | `target`                          |

`target/` is a generated source from Maven. It can be deleted and rebuilt, thus it should be in the gitignore

- production should be in the main folder, not among the unit tests.
- passwords should not be kept as those get commited and can become a security risk
- those are bytecode and are not meant to be edited by humans as the main java files can be rebuilt at any time
- A lack of testing can increase the risk of production products later down the line increasing cost of fixing any bugs later found