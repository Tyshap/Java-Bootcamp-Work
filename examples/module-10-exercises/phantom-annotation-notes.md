| Seen in suggestion          | Likely real?   | Prep action                   |
|-----------------------------|----------------|-------------------------------|
| @Entity / @Table            | JPA only       | Defer — not Lab 10 scope      |
| @Service / @Autowired       | Spring         | Defer — hosting labs later    |
| @NotNull (Jakarta)          | Validation lib | Name it; don't invent imports |
| public record Customer(...) | Java 16+       | OK on JDK 21                  |
| @local / @remote            | EJB            | Defer — not Lab 10 scope      |

Reject any import I cannot name from JDK 21 or an agreed Maven Dependency.

`CUS-1002` is a prospect, so the `status` field should be a boolean `isActive` instead of an enum.