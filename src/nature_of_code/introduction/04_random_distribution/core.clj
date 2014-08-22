(ns nature-of-code.introduction.04-random-distribution.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (vec (repeat 20 0)))

(defn update [state]
  (let [index (int (q/random (count state)))]
     (assoc state index (inc (get state index)))))

(defn draw [state]
  (q/background 255)
  (q/stroke 0)
  (q/fill 175)

  (let [w (/ (q/width) (count state))]
    (dorun (map-indexed
      #(q/rect (* %1 w) (- (q/height) %2) (- w 1) %2)
      state))))

(q/defsketch nature-of-code
  :size [640 240]
  :setup setup
  :draw draw
  :update update
  :middleware [m/fun-mode])
