# Lab 2 Notes

## Overview

The lab has overall gone successfully as I have implemented multiple classes as a package that were\
able to be compiled and execute together. My biggest difficulty came during compilation as I got compilation errors\
where the student class wasn't being recognized but after going through the code thoroughly I found\
that I had mistyped some method calls to the `Student` class. While I have opted to stick to simple input\
validation for now, in the future using try/catch blocks will be imperitive once my code becomes more complicated and\
becomes designed for greater deployment, as those errors become helpful for debugging as well as unit testing.

## Reflection

1. The package folder tree should match the `package com.academy.student` to keep the package globally unique and to keep the project organized
2. `nextLine()` and parsing make sense in menu apps since `nextLine()` consumes the `\n` that is generated with each input, and menus often have multiple required inputs
3. The `students.length` operation requires memory parsing in order to calculate, whereas the static `studentCount` variable is an `O(1)` operation that is only called when necessary and easy to reference
4. The `Main` class is where the program will physically execute from, so it  handles the menu actions, but the `StudentManager` is handling all of the actual processes for the menu as well as handling the students and their inputs.
5. It gives good foundational knowledge of Object Oriented Programming where functions are used as building blocks for each feature you would want built into a program and how to integrate those functions into a proper program