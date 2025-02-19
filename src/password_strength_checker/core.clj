(ns password-strength-checker.core
  (:require [clojure.string :as str]))

(defn pass-size [input]
  (count input))
;; use re-find for each regex
(re-find #"[0-9]" "abdc1dsdf")

(defn strength-calc [password]
  () (+ (pass-size password)))