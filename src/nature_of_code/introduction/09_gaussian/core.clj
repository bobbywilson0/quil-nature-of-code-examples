(ns nature-of-code.introduction.09-gaussian.core
  (:require [quil.core :as q]))

(defn setup []
  (q/background 255))

(defn draw []
  (let [sd 60
        mean (/ (q/width) 2)
        x (+ (* sd (q/random-gaussian)) mean)]
     (q/no-stroke)
     (q/fill 0 10)
     (q/ellipse x 180 16 16)))


(q/defsketch nature-of-code
  :size [640 360]
  :setup setup
  :draw draw)
