# Lab 18 — Stub vs Verify

## Stub (arrange)
Stub: when(repo.findById("CUS-1002")).thenReturn(raviProspect)

## Verify (assert collaboration)
Verify: verify(repo).save(…)

## One sentence — both roles
Both: stubs feed inputs; verifies prove side-effect calls.

## Scope
Pre-lab only.