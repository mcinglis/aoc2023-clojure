; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day02
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn parse-round [s]
  (->> s
       (#(str/split % #", "))
       (map (fn [sel]
              (let [[_ cnt color] (re-matches #"(\d+) (\w+)" sel)]
                {color (parse-long cnt)})))
       (apply merge)))

(defn parse-game [s]
  (let [[_ id-str rounds-str] (re-matches #"^Game (\d+): (.*)$" s)]
    {:game/id (parse-long id-str)
     :game/rounds (->> rounds-str
                       (#(str/split % #"; "))
                       (map parse-round))}))

(def assumed-bag-cubes {"red" 12 "green" 13 "blue" 14})

(defn possible-round? [round]
  (every? (fn [[color cnt]]
            (<= cnt (assumed-bag-cubes color)))
          round))

(defn possible-game? [game]
  (->> game
       (:game/rounds)
       (every? possible-round?)))

(defn possible-game-ids-sum
  "Implements the core solution for Day 2 Part 1."
  [lines]
  (->> lines
       (map parse-game)
       (filter possible-game?)
       (map :game/id)
       (apply +)))

(defn game-minimum-cubes [game]
  (map (fn [color]
         (->> game
              :game/rounds
              (map #(or (% color) 0))
              (apply max)))
       ["red" "green" "blue"]))

(defn games-minimum-cubes-power-sum
  "Implements the core solution for Day 2 Part 2."
  [lines]
  (->> lines
       (map #(->> %
                  (parse-game)
                  (game-minimum-cubes)
                  (apply *)))
       (apply +)))

(defn compute-answers []
  (with-open [reader (->> "inputs/day02.txt"
                          io/resource
                          io/reader)]
    (let [lines (line-seq reader)]
      [(possible-game-ids-sum lines)
       (games-minimum-cubes-power-sum lines)])))

