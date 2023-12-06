; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day03-test
  (:require [clojure.test :refer :all]
            [au.id.minglis.aoc2023.day03 :as m]))

(def example-schematic
  ["467..114.."
   "...*......"
   "..35..633."
   "......#..."
   "617*......"
   ".....+.58."
   "..592....."
   "......755."
   "...$.*...."
   ".664.598.."])

(deftest test-part-number-sum
  (is (= 4361 (m/part-number-sum example-schematic))))

(deftest test-gear-ratio-sum
  (is (= 467835 (m/gear-ratio-sum example-schematic))))

(deftest test-compute-answers
  (is (= [535351 87287096] (m/compute-answers))))

