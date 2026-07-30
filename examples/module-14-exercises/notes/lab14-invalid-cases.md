# Lab 14 — Invalid Cases Catalog

## Step 2 — Activate invalids

Activate missing id; activate CUS-9999 unknown (tie to API errors later).\
{ "fullName": "", "status": "PROSPECT" } // blank name\
{ "fullName": "Amina Khan", "status": "ACTVE" } // status typo\
{ "fullName": "A...A" } // 300 chars, oversized name\



## Step 3 — Valid control

Control: create Ravi-shaped PROSPECT with non-blank name.\
// Valid control: { "fullName": "Ravi Shah", "status": "PROSPECT" }

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.
