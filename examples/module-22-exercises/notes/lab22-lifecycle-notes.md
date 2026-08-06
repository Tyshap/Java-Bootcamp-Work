# Lab 22 — Bean Lifecycle Callbacks

## Lifecycle order
Create → Inject → @PostConstruct → Use → @PreDestroy.

## @PostConstruct purpose
log init once; log destroy on context close.

## @PreDestroy purpose
Do not create CUS-1001 inside @PostConstruct for every request.

## What not to do in init
one shared service instance.

## Scope
Pre-lab only.