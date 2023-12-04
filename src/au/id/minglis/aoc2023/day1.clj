; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day1
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn calibration-values-sum-part1
  "Implements the core solution for Day 1 Part 1."
  [lines]
  (->> lines
       (map (fn [line] (->> line
                            (re-seq #"\d")
                            (#(str (first %) (last %)))
                            (Integer/parseInt))))
       (apply +)))

(def numeric-words {"one" "1"
                    "two" "2"
                    "three" "3"
                    "four" "4"
                    "five" "5"
                    "six" "6"
                    "seven" "7"
                    "eight" "8"
                    "nine" "9"})

(def numeric-pattern
  (re-pattern (str "(\\d|" (str/join "|" (keys numeric-words)) ")")))

(defn calibration-values-sum-part2
  "Implements the core solution for Day 1 Part 2."
  [lines]
  (->> lines
       (map (fn [line]
              (->> (let [m (re-matcher numeric-pattern line)]
                     ; Find all numeric words, potentially overlapping:
                     (loop [i 0 words []]
                       (if (.find m i)
                         (recur (inc (.start m))
                                (conj words (.group m)))
                         words)))
                   ; Turn numeric words into their number equivalent:
                   (map #(or (numeric-words %) %))
                   ; Combine back into a singular string:
                   (apply str))))
       (calibration-values-sum-part1)))

(defn compute-answers []
  (with-open [reader (->> "inputs/day1.txt"
                          io/resource
                          io/reader)]
    (let [lines (line-seq reader)]
      [(calibration-values-sum-part1 lines)
       (calibration-values-sum-part2 lines)])))

