(ns nature-of-code.introduction.06_walker_tends_to_right.walker
  (:require [quil.core :as q]
            [quil.middleware :as m]))

  (defn render [x, y]
    (q/stroke 0)
    (q/point x, y))

  (defn step [x, y]
    (let [r (q/random 1)
         [x, y]
            (cond
              (< r 0.4) [(inc x), y]
              (< r 0.6) [(dec x), y]
              (< r 0.8) [x, (inc y)]
              :else [x, (dec y)])]
      {:x (q/constrain x 0 (- (q/width) 1))
       :y (q/constrain y 0 (- (q/height) 1))}))