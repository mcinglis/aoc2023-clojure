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

(deftest test-calibration-values-sum
  (is (= 96
         (m/calibration-values-sum
           ["2aoidjioj5uhiuha"
            "oiajdsijxmcn4a0ioiqowi"
            "oqwpeoqweipiop20"
            "xiqmoiqwiox1oiqmweimom"]))))

(deftest test-compute-answers
  (is (= [55538] (m/compute-answers))))
