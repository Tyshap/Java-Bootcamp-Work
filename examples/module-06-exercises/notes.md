# Module 6 notes

## Exercise  2

- Alice -- 72,000 Keep
- Bob -- 65,000 Keep
- Charlie -- 80,0000 Keep
- Diana -- 90,000 Keep
- Evan -- 55,000 Discard

## Exercise 3

Before map: Stream\<Employee>\
Mapping function: Employee::name\
After map: Stream\<String>\
Final result: List<String>

## Exercise 4

- Evan (65,000)
- Bob(65,000)
- Alice(72,000)
- Charlie(80,000)
- Diana(90,000)

## Exercise 5

72000 * 1.1 = 79200

## Exercise 6

Finance -> Diana
HR      -> Alice, Charlie
IT      -> Bob, Evan

## Exercise 7

filter: Stream\<Employee> -> Stream\<Employee>\
map:    Stream\<Employee> -> Stream<\String>\
sorted: Stream\<String>   -> Stream\<String>\
toList: Stream\<String>   -> List\<String>

Department Filtering is a simpler process to do with the whole\
object as opposed to just the string, where once we have the name strings from the\
department we no longer need the object.

## Exercise 8

The parallel stream worked much faster every time likely due to my CPU count where\
multithreading matters much more with more computer cores.