# Lab 12 — Equals vs ==

## Reference

| Check | Use | Why |
| --- | --- | --- |
| status ACTIVE? | Objects.equals / enum | String identity is unsafe |
| same Customer instance? | == | Reference equality only |
| id CUS-1001? | equals | Value equality |

## Step 2 — Bad snippet

`if (status == "ACTIVE")` FAIL


## Step 3 — Good snippet

Write a good conceptual check for Amina ACTIVE using equals or enum.

`if (Amina.getStatus().equals(CustomerStatus.ACTIVE))` PASS

## Step 4 — JDK note

Note: prefer enums on JDK 21 sketches when status set is closed.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.