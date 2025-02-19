This program has been designed to calculate a password strength "score" to determine whether or not your password has a traditionally "high" enough score to be stored by common websites.
The usual criteria for password strength is:
- Containing an upper case letter
- Containing a lower case letter
- Containing a special symbol ex. $%^+
- Containing at least one number
- A length greater or equal to 8 characters

This program calculates strength by multiplying the scores of these criteria to hit a minimum of 100 points, where passwords scoring less than 100 are deemed too weak, and should be discarded by input systems. This code isn't intended for storage or security of said passwords, but instead a step within a password validation process, this allows for future modifications if standards change, as well as protecting future steps from malicious uses. A potential limitation for this code is the assumptions made in calculating the score. This code does not sanitize user input, and could be used in SQL injections, or future attacks. There are some cases where the strength score "passes" the minimum 100, but would be considered weak, say a 100 length string of "$" or other special characters.
This program has been written in clojure, a particularly powerful functional LISP that runs on the JVM.
The guide to install clojure:
https://clojure.org/guides/install_clojure .
Clojure runs on the JVM, which means under the hood it's comprised of Java classes, despite looking so unusual.
This means that installing clojure requires the latest version of Java (Version 8 Update 441 of time of writing),
and installing an editor that has plugins to run its REPL. Listed on the official clojure website include:
- VSCode
- Emacs
- Neovim/Vim
- Intellij

You should clone this repo to correctly download all the files required, https://github.com/gtag8375/password-strength-checker.git and 
ensure clojure is correctly installed. To run this program simple start up a REPL in any of these editors with the correct plugin, and run the 'final-score' function along with 
the string to check for it's score. In clojure, parenthesis encase both the function and it's arguments. An example in python 
compared to clojure would be:

password_check(input)

while clojure's implementation looks like:

(password-check input)

Like python and javascript, clojure is dynamically typed, meaning that there are no explicit types for either the arguments of a function
or the return type of a function. This means we should be careful to call the 'final-score' function with strings, or else it can return unintended results.

To properly use password_strength_check, we need to ensure we're in the correct namespace (clojure's version of classes).
Once our REPL is properly running the output should look like this:
```clojure
"C:\Program Files\Java\jdk-19\bin\java.exe"
Connecting to local nREPL server...
Clojure 1.11.1
nREPL server started on port 64757 on host 127.0.0.1 - nrepl://127.0.0.1:64757
```
Once our repl has been properly connected, we should navigate to the correct namespace like the below command:
```clojure
(ns password-strength-checker.core)
```
We can now use the 'final score' command in our REPL. As an example let's input password "ABCdef1?"
```clojure 
(final-score "ABCdef1?")
=> 101.55995666841604
```
This password would pass our "strong password" criteria, and could then be allowed by further processes to be stored/validated more thouroughly.
```clojure
(final-score "12")
=> 2.16
```
On the other hand, a password that doesn't meet the requirements will never be greater than 100, and thus we can ask the user to
retry with a password that passes the checks.
