# Lab 21 — Liveness vs Readiness

## Liveness
Liveness: process stuck → restart (e.g., deadlocked threads).

## Readiness
Readiness: dependency down → not ready, keep process.

## Wrong mix
Wrong mix: restarting on transient DB outage.

## Lab expectation
Lab: toggle CrmReadinessIndicator OUT_OF_SERVICE; liveness stays UP.

## Scope
Pre-lab only.