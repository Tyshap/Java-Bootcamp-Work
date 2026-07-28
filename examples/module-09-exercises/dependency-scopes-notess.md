# Dependency Scopes Notes

| Dependency need | Scope    |
| --------------- |----------|
| JUnit Jupiter used only in `src/test/java` | test     |
| Spring Context API called from production sources (Lab 9 learning placeholder) | compile  |
| JDBC driver you never import in Java source but need at runtime later | runtime  |
| API the application server will provide in production | provided |