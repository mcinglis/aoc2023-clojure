(ns user
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.repl :refer :all]
            [clojure.test :as test]
            [clojure.tools.namespace.repl]))

(defn require-day-packages [day]
  (def DAY day)
  (require [(symbol (str "au.id.minglis.aoc2023.day" DAY)) :refer :all])
  (require [(symbol (str "au.id.minglis.aoc2023.day" DAY "-test")) :as 't]))

(defn refresh []
  (clojure.tools.namespace.repl/refresh)
  (ns-unalias *ns* 't)
  (alias 't (symbol (str "au.id.minglis.aoc2023.day" DAY "-test"))))

