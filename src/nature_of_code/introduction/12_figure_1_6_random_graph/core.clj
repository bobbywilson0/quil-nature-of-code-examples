(ns nature-of-code.introduction.12-figure-1-6-random-graph.core
  (:require [quil.core :as q]))

(defn setup []
  (q/background 255))

(defn draw []
  (q/no-fill)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/begin-shape)
  (dorun (map #(q/vertex % (q/random (q/height))) (range (q/width))))
  (q/end-shape)
  (q/no-loop))


(q/defsketch nature-of-code
  :size [400 200]
  :setup setup
  :draw draw)
