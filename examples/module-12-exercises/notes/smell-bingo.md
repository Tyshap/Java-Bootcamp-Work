# Lab 12 — Smell Bingo

## Step 1 — Smell list

Bingo card:\
long method,\
magic strings for ACTIVE/PROSPECT,\
== on Strings, mixed I/O in domain,\
unclear names.

## Step 2 — Fixture tie-in

For each smell, note how it could corrupt CUS-1001 / CUS-1002 handling.
Long methods could cause difficulties in understanding the flow of customer information, causing future code to become unreliable.\
Hardcoded fixtures can cause later issues if changes need to be made, it's better to use constants or enums.\
Using == on Strings can lead to unexpected behavior, as it checks for reference equality rather than value.\
unclear names can make it difficult to understand the purpose of variables and methods, leading to confusion and potential bugs.

## Step 3 — Priority

Star the two smells you will fix first in the timed lab.
I will fix using == on Strings and unclear names first, as they can lead to unexpected behavior and confusion in the code.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.