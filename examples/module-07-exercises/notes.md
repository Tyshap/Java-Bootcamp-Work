# Module 7 Notes

## Exercise 2 Try Block Trace

Success: try → finally → return\
Failure: try throws → catch → finally → return

Finally runs no matter what, the try method runs until an exception is thrown\
which then calls to the catch area of the try block. Finally is always run before the return.