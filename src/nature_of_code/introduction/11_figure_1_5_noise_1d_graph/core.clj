(ns nature-of-code.introduction.11_figure_1_5_noise_1d_graph.core
  (:require [quil.core :as q]))

(def t (atom 0.0))

(defn setup []
  (q/smooth))

(defn draw []
  (q/background 255)
  (q/no-fill)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/begin-shape)
  (loop [xoff @t
        i 0]
    (q/vertex i (* (q/noise xoff) (q/height)))
    (if (<= i (q/width))
      (recur (+ xoff 0.01) (inc i))))
  (q/end-shape)
  (swap! t + 0.01))


(q/defsketch nature-of-code
  :size [400 200]
  :setup setup
  :draw draw)
