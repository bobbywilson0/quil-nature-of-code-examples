(ns nature-of-code.introduction.13-random-walk-noise.core
  (:require [quil.core :as q]
            [nature-of-code.introduction.13-random-walk-noise.walker :as walker]))

(defn setup []
  (q/background 0))

(defn draw []
  (walker/step)
  (walker/render))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :size [640 360])
