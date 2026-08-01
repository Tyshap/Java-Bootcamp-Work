# Lab 16 — Failure to Status Map

## Reference

| Failure | Status idea |
| --- | --- |
| CUS-9999 not found | 404 / SOAP Client fault |
| Activate Amina illegal transition | 409 or 422 |
| Validation blank name | 400 |
| Unexpected bug | 500 (generic message) |

## Step 2 — Choose conflict

Pick 409 vs 422 for illegal activate and write one reason.

409: While the input is correct it is attempting an action that is not performable in the current state, creating a conflict.

## Step 3 — Never

Write: never return 200 with an error payload for these failures.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.