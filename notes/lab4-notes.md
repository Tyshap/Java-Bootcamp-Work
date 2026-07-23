# Lab 4 Notes

## Memory Leak Report

![My App Setup](screenshots/lab-4/Memory-Report-1.png)
![My App Setup](screenshots/lab-4/Memory-Report-2.png)

The primary difference between the memory leak version and the fixed version is
that the array in the memory leaked version gets stored in a static field, meaning it goes 
onto the heap, while in the fixed version the array never leaves the heap and is therefore easy
to remove from memory via garbace collection.

## Performance Table

![My App Setup](screenshots/lab-4/Performance-Report.png)

## Garbage Collector Log

![My App Setup](screenshots/lab-4/GC-Logging-evidence.png)