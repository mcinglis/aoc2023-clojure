; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day1
  (:require [clojure.java.io :as io]))

(defn calibration-values-sum [lines]
  (->> lines
       (map (fn [line] (->> line
                            (re-seq #"\d")
                            (#(str (first %) (last %)))
                            (Integer/parseInt))))
       (apply +)))

(defn compute-answers []
  (with-open [reader (->> "inputs/day1.txt"
                          io/resource
                          io/reader)]
    (let [lines (line-seq reader)]
      [(calibration-values-sum lines)])))

