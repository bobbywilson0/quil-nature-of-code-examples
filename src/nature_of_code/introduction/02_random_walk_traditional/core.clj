(ns nature-of-code.introduction.02-random-walk-traditional.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [nature-of-code.introduction.02-random-walk-traditional.walker :as walker]))

(defn setup []
  (q/background 255)
  {:x (/ (q/width) 2), :y (/ (q/height) 2)})

(defn update [state]
  (walker/step (:x state) (:y state)))

(defn draw [state]
  (walker/render (:x state) (:y state)))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :update update
  :size [640 360]
  :middleware [m/fun-mode])
