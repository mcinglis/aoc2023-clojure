; Copyright (C) 2023  Malcolm Inglis <me@minglis.id.au>
; SPDX-License-Identifier: AGPL-3.0-only
;
; This software is licensed under the terms of the GNU AGPLv3 License
; as provided in the package's LICENSE file, or otherwise available at
; <https://www.gnu.org/licenses/agpl-3.0.txt>. As described therein,
; this code is provided WITHOUT ANY WARRANTY; without even the implied
; warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

(ns au.id.minglis.aoc2023.day1-test
  (:require [clojure.test :refer :all]
            [au.id.minglis.aoc2023.day1 :as m]))

(deftest test-calibration-values-sum-part1
  (are [expected lines]
       (= (m/calibration-values-sum-part1 lines) expected)
       96 ["2aoidjioj5uhiuha"
           "oiajdsijxmcn4a0ioiqowi"
           "oqwpeoqweipiop20"
           "xiqmoiqwiox1oiqmweimom"]
       142 ["1abc2"
            "pqr3stu8vwx"
            "a1b2c3d4e5f"
            "treb7uchet"]))

(deftest test-calibration-values-sum-part2
  (are [expected lines]
       (= (m/calibration-values-sum-part2 lines) expected)
       96 ["2aoidjioj5uhiuha"
           "oiajdsijxmcn4a0ioiqowi"
           "oqwpeoqweipiop20"
           "xiqmoiqwiox1oiqmweimom"]
       281 ["two1nine"
            "eightwothree"
            "abcone2threexyz"
            "xtwone3four"
            "4nineeightseven2"
            "zoneight234"
            "7pqrstsixteen"]
       88 ["eight"]
       21 ["twone"]
       21 ["twoone"]
       55 ["5"]
       28 ["atwoneight"]
       18 ["oneight"]))

(deftest test-compute-answers
  (is (= [55538 54875] (m/compute-answers))))
