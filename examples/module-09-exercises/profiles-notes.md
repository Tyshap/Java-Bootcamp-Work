# Activate Build Profiles Notes

| Question | Your answer  |
| -------- |--------------|
| Which profile is active when you run plain `mvn package`? | `dev`        |
| How do you activate `prod` on the command line? | `mvn -Pprod` |
| What is the `app.env` value under `dev`? | `dev`        |
| What is the `app.env` value under `prod`? | `prod`        |

# Errors

- Putting database passwords inside of the dev profile could lead to potential dataleaks
- if every engineer is pushing to production, it could result in either merge errors or undetected bugs being pushed to prodcution
- It could cause overwritten classes if you assume that changing the profile changes java package names
- screenshots of secrets is also a security risk.
