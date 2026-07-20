The source code is what the developer is writing, which then gets translated into bytecode by the compiler (javac) to
be understandable by the machine. JVM then takes that bytecode and executes it by loading the class into memory,
uses Bytecode verification to check for security vulnerabilities, prepares memory for execution, then runs the bytecode
line by line to be output by the machine.