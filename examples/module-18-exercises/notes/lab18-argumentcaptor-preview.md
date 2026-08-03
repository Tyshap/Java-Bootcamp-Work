# Lab 18 — ArgumentCaptor Preview

## Declare
ArgumentCaptor<Customer>
## Verify + capture
verify(repo).save(captor.capture())

## Assert
Assert captor.getValue().getStatus() == ACTIVE for Ravi.

## Scope
Pre-lab only.