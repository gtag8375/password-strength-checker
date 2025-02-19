(ns password-strength-checker.core
  (:require [clojure.string :as str]))

(defn pass-count [input]
  ;; count the size of the input. Should be greater than 8
  (count input))
(defn pass-size [input]
  ;; will return false if not 8 or longer.
  (> (count input) 7))
(defn digit? [input]
  ;; returns nil if no digit is found, while returning the digit found if any within the input.
  (re-find #"[0-9]" input))
(defn lower? [input]
  ;; returns nil if no lower is found, else returns string lower char found.
  (re-find #"[a-z]" input))
(defn upper? [input]
  ;; returns nil if no upper is found, else returns string upper char found.
  (re-find #"[A-Z]" input))
(defn special? [input]
  ;; returns nil if no special character is found, else returns the special character found.
  (re-find #"[!@#$%^&*()_+\-=\[\]{};:\"\\|,.<>/?]" input))
(defn calculate-score [password]
  ;; Multiplies the values of each by 5 or 1 depending on weather or not they pass.
  ;; in clojure, the if statement returns false for nil values, so if a nil is returned,
  ;; a 1 is returned. A total score of 101.6... is possible. We know we shouldn't allow scores under 101.6...
  (* (if (pass-size password) 2.16 1)
     (if (> (count password) 7) 2.16 1)
     (if (digit? password) 2.16 1)
     (if (lower? password) 2.16 1)
     (if (upper? password) 2.16 1)
     (if (special? password) 2.16 1)))
(defn final-score [password]
  ;; A function to calculate the final score.
  (calculate-score password))