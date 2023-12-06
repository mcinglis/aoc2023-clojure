; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day04
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(defn numbers-str->set [s]
  (->> s
       (re-seq #"\d+")
       (map parse-long)
       (into #{})))

(defn parse-card [s]
  (let [[_ card-number winning-str have-str]
        (re-matches
          #"^Card\s+(\d+):\s+(\d+(?:\s+\d+)*)\s+\|\s+(\d+(?:\s+\d+)*).*$"
          s)]
    {:card card-number
     :winning (numbers-str->set winning-str)
     :have (numbers-str->set have-str)}))

(defn parse-cards [lines]
  (map parse-card lines))

(defn card-count-matching [{:keys [winning have]}]
  (count (set/intersection winning have)))

(defn card-score [card]
  (->> card
       card-count-matching
       dec
       (#(if (neg? %) 0 (long (Math/pow 2M %))))))

(defn total-cards-scores
  "Implements the core solution for Day 4 Part 1."
  [lines]
  (->> lines
       parse-cards
       (map card-score)
       (apply +)))

(defn total-winning-cards
  "Implements the core solution for Day 4 Part 2."
  [lines]
  (let [counts (->> lines
                    parse-cards
                    (map card-count-matching)
                    vec)]
    (->> (reductions
           (fn [[c & cs] score]
             (map + cs (concat (repeat score c) (repeat 0))))
           (repeat (count counts) 1)
           counts)
         (keep first)
         (apply +))))

(defn compute-answers []
  (with-open [reader (->> "inputs/day04.txt"
                          io/resource
                          io/reader)]
    (let [lines (line-seq reader)]
      [(total-cards-scores lines)
       (total-winning-cards lines)])))
