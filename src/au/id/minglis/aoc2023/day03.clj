; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day03
  (:require [clojure.java.io :as io]))

(defn parse-symbols [lines]
  "Parses a seq of maps, representing the symbols and their positions."
  (->> lines
       (map-indexed
         (fn [y line]
           (let [m (re-matcher #"[-*#+$=&@/%]" line)]
             (loop [res []]
               (if (.find m)
                 (recur (conj res {:sym (.group m)
                                   :x (.start m)
                                   :y y}))
                 res)))))
       (apply concat)))

(defn parse-numbers [lines]
  "Parses a seq of maps, representing the numbers and their positions."
  (->> lines
       (map-indexed
         (fn [y line]
           (let [m (re-matcher #"\d+" line)]
             (loop [res []]
               (if (.find m)
                 (recur (conj res
                              {:number (parse-long (.group m))
                               :x-start (.start m)
                               :x-end (dec (.end m))
                               :y y}))
                 res)))))
       (apply concat)))

(defn symbols->coord-map [symbols]
  "Transforms a symbols seq into a map of {[x y] sym ...}."
  (->> symbols
       (map (fn [{:keys [sym x y]}] [[x y] sym]))
       (into {})))

(defn adjacent-coords [{:keys [x-start x-end y]}]
  "Returns a vec of all adjacent coordinates."
  (for [ay (range (max 0 (dec y)) (+ y 2))
        ax (range (max 0 (dec x-start)) (+ x-end 2))
        :when (not (and (<= x-start ax x-end) (= y ay)))]
    [ax ay]))

(defn part-number? [symbol-coords number]
  "A number is a part number if it is adjacent to a symbol."
  (boolean (some #(contains? symbol-coords %)
                 (adjacent-coords number))))

(defn part-number-sum [lines]
  "Implements the core solution for Day 3 Part 1."
  (let [symbol-coords (-> lines parse-symbols symbols->coord-map)
        numbers (-> lines parse-numbers)]
    (->> numbers
         (filter #(part-number? symbol-coords %))
         (map :number)
         (apply +))))

(defn numbers->coord-map [numbers]
  "Transforms a numbers seq into a map of {[x y] {num} ...}, for every
   [x y] coordinate that the number occupies."
  (->> numbers
       (map (fn [{:keys [x-start x-end y] :as number}]
              (for [x (range x-start (inc x-end))]
                [[x y] number])))
       (apply concat)
       (into {})))

(defn adjacent-numbers [number-coords [x y]]
  "Returns a set of all numbers adjacent to given the coordinates."
  (->> (adjacent-coords {:x-start x :x-end x :y y})
       (keep number-coords)
       (into #{})))

(defn gear-ratio [number-coords {:keys [sym x y]}]
  "Returns the symbol's gear ratio for the given numbers coordinate map,
   or nil if this symbol is not a gear ('*', adjacent to exactly 2 numbers)."
  (let [adj (adjacent-numbers number-coords [x y])]
    (if (and (= sym "*") (= 2 (count adj)))
      (->> adj (map :number) (apply *))
      nil)))

(defn gear-ratio-sum [lines]
  "Implements the core solution for Day 3 Part 2."
  (let [symbols (-> lines parse-symbols)
        number-coords (-> lines parse-numbers numbers->coord-map)]
    (->> symbols
         (keep #(gear-ratio number-coords %))
         (apply +))))

(defn compute-answers []
  (with-open [reader (->> "inputs/day03.txt"
                          io/resource
                          io/reader)]
    (let [lines (line-seq reader)]
      [(part-number-sum lines)
       (gear-ratio-sum lines)])))

