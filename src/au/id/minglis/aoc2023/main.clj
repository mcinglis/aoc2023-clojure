; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.main
  (:require [au.id.minglis.aoc2023.day01 :as day01]
            [au.id.minglis.aoc2023.day02 :as day02]
            [au.id.minglis.aoc2023.day03 :as day03]))

(defn -main [& args]
  (println (str "Day 3: " (time (day03/compute-answers))))
  (println (str "Day 2: " (time (day02/compute-answers))))
  (println (str "Day 1: " (time (day01/compute-answers)))))

