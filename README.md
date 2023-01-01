# java-reference
My personal Java cheat-sheet, patterns, and best practices.

You can compile the Java file using this command:
`$ javac EntryPoint.java`

This produces a file called "EntryPoint.class", which we can then run as follows:
`$ java EntryPoint`

- The source filename "EntryPoint.java" must match the class name in the source file.
    - If they don't match, you will get a compilation error.
- The bytecode filename "EntryPoint.class" corresponds to the classname.
     - If you were to rename the "EntryPoint.class", you would get an error when your tried to run it.
- When running a Java application using `java`, you supply the classname NOT the bytecode filename.

## Packages
If we wanted to declare a class in a package call com.saeid.main, we can define the package this way: 
`package com.saeid.main;`

- The directory structure must match the package name structure.
- When you run the class, the full class name must be supplied.
    - E.g. `com.saeid.main`.

## Compiling multiple files
You can compile multiple files at the same time by listing the pathnames:
`$ javac Foo.java Bar.java`

Or upi can use command shell's filename wildcard functionality:
```
$ javac *.java
$ javac com/example/*.java
$ javac */**/*.java #Only works on Zsh or with globstar enabled on your shell
```

