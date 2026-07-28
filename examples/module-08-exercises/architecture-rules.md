# Dependency Notes



| Dependency              | Decision      | Why                                                                 |
|-------------------------|---------------|---------------------------------------------------------------------|
| controller → service    | Acceptabble   | Controller should make calls for service to act upon                |
| service → repository    | Acceptable    | Service should check on entity status and make calls to entities    |
| repository → entity     | Acceptable    | Respository should check on entity status                           |
| entity → controller     | Problematic   | Domain depends on transport                                         |
| repository → controller | Problematic   | persistence depends on presentation                                 |
| service → DTO           | Needs Context | In smaller local package its fine, but careful of transport leakage |
| DTO → repository        | Problematic   | bound model should not hold local storage                           |

## Explenations

 If calls begin to loop between packages, it makes stack traces much harder to read for debugging.

-BAD: controller -> service -> repository -> controller

-FIX: controller -> service -> repository -> entity