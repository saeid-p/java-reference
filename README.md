# java-reference
My personal Java cheat-sheet, patterns, and best practices.

You can compile the Java file using this command:
`$ javac EntryPoint.java`

This produces a file called "EntryPoint.class", which we can then run as follows:
`$ java EntryPoint`

If the command requires command-line arguments, add them after the <jar-path>. For example:
`$ java -jar <jar-path> arg1 arg2 arg3`

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
You can compile multiple files at the same time by listing the pathn ames:
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

Unless we are using in the java -jar command syntax, the java command looks for the class to be loaded by searching the classpath; see The Classpath. The above command is relying on the default classpath being (or including) the current directory. We can be more explicit about this by specifying the classpath to be used using the -cp option.
`$ java -cp . HelloWorld`
This says to make the current directory (which is what "." refers to) the sole entry on the classpath.
The -cp is an option that is processed by the java command. All options that are intended for the java command should be before the classname. Anything after the class will be treated as an command line argument for the Java application, and will be passed to application in the String[] that is passed to the main method.
If no -cp option is provided, the java will use the classpath that is given by the CLASSPATH environment variable. If that variable is unset or empty, java uses "." as the default classpath.

## Selecting the VM type
The -client and -server options allow you to select between two different forms of the HotSpot VM:
- The "client" form is tuned for user applications and offers faster startup.
- The "server" form is tuned for long running applications. It takes longer capturing statistic during JVM "warm up" which allows the JIT compiler to do a better of job of optimizing the native code.

By default, the JVM will run in 64bit mode if possible, depending on the capabilities of the platform. The -d32 and -d64 options allow you to select the mode explicitly.