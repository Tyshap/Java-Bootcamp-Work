# Module 4 Notes

## StackHeapDemo Trace

```mermaid

flowchart LR
    subgraph Stack["Thread stack"]
        M["main frame<br/>count = 1<br/>person reference<br/>return (remove frame)"]
        P["printPerson frame<br/>person reference<br/>nameLength = 4<br/>return (remove frame)"]
    end
    subgraph Heap["Shared heap"]
        O["Person object<br/>name -> String 'Aman'"]
        
    end
    M -- Reference --> O 
    P -- Reference --> O


```

## Object Lifecycle Notes

While the `==` operator won't specifically verify that every variable within the object is the same, it will still verify that the objects are the same by comparing the references to each other.
An object is not collectible merely because one reference becomes null.
It becomes GC-eligible only when no live strong-reference path can reach it.
Eligibility does not guarantee immediate collection, and System.gc() is only
a request.

Personal Note: While Garbage Collection prevents memory leaks that would be possible in other languages, it also prevents extreme forms of optimization, **only create objects when necessary** to prevent a pileup of too many objects in memory. For larger projects, writing to file and referencing file may solve some memory issues, but creates security risk.

## Observed Garbage Collection

The Program Only Needed to allocate approximately 50 MB for the program over 20 rounds, however without the limiter the program Allocated approximately 184MB.
I've noticed the step in which Memory is freed is likely through the Pause Remark and Pause Cleanup, where I'm guessing that the Bytes that were allocated but hold no references
were removed. There also Seems to be a G1 Evacuation event for when the memory grows too large and space needs to be cleared, though I am unsure of what it specifically does.
The exact pause times were different for each event, but never exceeded 5.1 milliseconds. Overall Execution took 0.08 seconds.