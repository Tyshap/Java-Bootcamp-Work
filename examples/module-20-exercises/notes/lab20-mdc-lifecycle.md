# Lab 20 — MDC Lifecycle

## Put
Put: MDC.put("corr", "lab-request-001") on entry.

## Use
Use: service logs include corr via %X{corr}.

## Clear
Clear: finally { MDC.clear(); }

## Lab 21 boundary
Metrics/Actuator wait for Lab 21.

## Scope
Pre-lab only.