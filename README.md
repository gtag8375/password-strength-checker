This program has been designed to calculate a password strength "score" to determine whether or not your password has a traditionally "high" enough score to be stored by common websites.
The usual criteria for password strength is:
- Containing an upper case letter
- Containing a lower case letter
- Containing a special symbol ex. $%^+
- Containing at least one number
- A length greater or equal to 8 characters

This program calculates strength by multiplying the scores of these criteria to hit a minimum of 100 points, where passwords scoring less than 100 are deemed too weak, and should be discarded by input systems. This code isn't intended for storage or security of said passwords, but instead a step within a password validation process, this allows for future modifications if standards change, as well as protecting future steps from malicious uses. A potential limitation for this code is the assumptions made in calculating the score. This code does not sanitize user input, and could be used in SQL injections, or future attacks. There are some cases where the strength score "passes" the minimum 100, but would be considered weak, say a 100 length string of "$" or other special characters.
This program has been written in clojure, a particularly powerful functional LISP that runs on the JVM.
To install clojure and run this program:


