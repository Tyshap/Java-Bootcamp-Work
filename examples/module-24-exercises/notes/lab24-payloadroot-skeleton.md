# Lab 24 — PayloadRoot Skeleton

## Class annotation
@Endpoint class CustomerEndpoint

## @PayloadRoot localPart
@PayloadRoot(namespace = NAMESPACE, localPart = "GetCustomerRequest")

## Method inputs/outputs
method getCustomer(@RequestPayload GetCustomerRequest req)

## Delegation line (words)
→ map → customerService.get(...) → map response

## Scope
Pre-lab only.