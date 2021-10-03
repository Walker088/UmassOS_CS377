# Simple Java Shell (Open JDK 11, Ubuntu 20.04.2 LTS)

## Quick Start
```bash
# Pre-Requirements: OpenJDK 11
$ ./jsh # Start the shell
```

## Requiements
An interactive shell program such as bash takes command line input from the user and then execute the command/program specified by the user. The first part of this assignment is to write a simple interactive shell in Java. Upon startup, your java shell should print a prompt "mysh>" and wait for user to type a command. When the user type any command (e.g., "/bin/ls -l") the java program should fork a new process, have the child process execute the specified command. The parent shell java process should wait for the process to finish and then it should display a new prompt "mysh>" indicating it is ready to accept new input from the user. "exit" can be used to exit the shell.

To write such a shell in Java, first review java documentation for the following (*Updated to jdk11*):

1. [JDK 11: Java Process class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Process.html)
2. [JDK 11: Java Runtime class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Runtime.html)

As noted in the document, you can use Runtime.exec() to create a new child process and have it execute a command. Similarly. the java process class provides methods to wait for a child process to finish. Use these methods (and/or any other methods that are necessary) to implement a simple shell as noted below.

For simplicity, assume that the user specifies the full path name for any command/executable that they wish to execute. Thus you do not need to deal with path name completion issues. As an example, the user should type "/bin/ls" rather than "ls".

## Project References:
- [Github: mjkhonline/simpleShell-java](https://github.com/mjkhonline/simpleShell-java)
- [Github: treelover28/simple-java-shell](https://github.com/treelover28/simple-java-shell)
- [it2051229: Simple Shell](https://www.it2051229.com/simpleshell.html)
- [Baeldung: Java Scanner](https://www.baeldung.com/java-scanner)
- [Baeldung: Guide to java.lang.Process API](https://www.baeldung.com/java-process-api)

---

## Notes

#### 1. Different classes for reading command line inputs
> Given the underlying stream passed to the constructors, both BufferedReader and Scanner classes are able to handle a wider range of user input, such as a string, file, system console (which is typically connected to the keyboard), and socket.
> On the other hand, the Console class is designed to only access the character-based system console, if any, associated with the current Java virtual machine.
>
> -- *Quote from Baeldung*

1. BufferedReader
    - Since Java 1.1
    - Throws checked exceptions
    - Can read chars, char arrays, and lines
    - Fast
2. Scanner
    - Since Java 1.5
    - Doesn't throw checked exceptions
    - Can read lines, whitespace-delimited tokens, regex-delimited tokens, and numbers
    - Difficult to read single characters
3. Console
    - Since Java 1.6
    - Doesn't throw checked exceptions
    - Can read lines
    - Underlying reader can read chars and char arrays (stops at line bounds)
    - Not always available (e.g. Eclipse)
    - Can read passwords (i.e. read without displaying the characters)

References:
- [StackOverflow: BufferedReader vs Console vs Scanner](https://stackoverflow.com/questions/17637032/bufferedreader-vs-console-vs-scanner)
- [Baeldung: BufferedReader vs Console vs Scanner in Java](https://www.baeldung.com/bufferedreader-vs-console-vs-scanner-in-java)
- [Oracle: Class Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html)
- [Oracle: Class BufferedReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html)
- [Oracle: Class Console](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Console.html)