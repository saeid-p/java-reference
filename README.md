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

You can use command shell's filename wildcard functionality:
```
$ javac *.java
$ javac com/example/*.java
$ javac */**/*.java #Only works on Zsh or with globstar enabled on your shell
```

Java is a dynamically bound language. When you run a Java application with library dependencies, the JVM needs to know where the dependencies are so that it can load classes as required. Broadly speaking, there are two ways to deal with this:
- The application and its dependencies can be repackaged into a single JAR file that contains all of the required classes and resources.
- The JVM can be told where to find the dependent JAR files via the runtime classpath.

For an executable JAR file, the runtime classpath is specified by the "Class-Path" manifest attribute. Otherwise, the runtime classpath needs to be supplied using the -cp option or using the CLASSPATH environment variable.
    - Suppose that we have a Java application in the "myApp.jar" file whose entry point class is com.example.MyApp. Suppose also that the application depends on library JAR files "lib/library1.jar" and "lib/library2.jar". We could launch the application using the java command as follows in a command line:
```
$ java -cp myApp.jar:lib/library1.jar:lib/library2.jar com.example.MyApp
$ # Alternative 2
$ export CLASSPATH=myApp.jar:lib/library1.jar:lib/library2.jar
$ java com.example.MyApp
```
On Windows, you would use ; instead of : as the classpath separator, and you would set the (local) CLASSPATH variable using set rather than export.