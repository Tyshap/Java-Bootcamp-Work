# POM Coordinates Notes

| Question | Your answer                                    |
| -------- |------------------------------------------------|
| What is the `groupId`? | `com.northstar`                                |
| What is the `artifactId`? | `customer-service`                             |
| What is the `version`? | `0.1.0-snapshot`                               |
| What is the packaging? | `jar` (Java Archice)                           |
| Write the full GAV (`groupId:artifactId:version`) | `com.northsatr:customer-service:0.1.0-snapshot` |

## Explanation

Snapshot versions are versions that are currently under development and are likely to receive revision before a full release.

## Errors

- The groupID should be `com.northstar.crm`
- the artifactId should be in camel case to match the file naming structure
- committing a different version on every laptop with no team agreement
- omitting <packaging> and assuming WAR for a plain Java library/app JAR