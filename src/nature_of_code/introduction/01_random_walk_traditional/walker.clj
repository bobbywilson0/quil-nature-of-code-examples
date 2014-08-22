(ns nature-of-code.introduction.01-random-walk-traditional.walker
  (:require [quil.core :as q]
            [quil.middleware :as m]))

  (defn render [x, y]
    (q/stroke 0)
    (q/point x, y))

  (defn step [x, y]
    (let [choice (int (q/random 4))
         [x, y]
            (cond
              (== choice 0) [(inc x), y]
              (== choice 1) [(dec x), y]
              (== choice 2) [x, (inc y)]
              :else [x, (dec y)])]
      {:x (q/constrain x 0 (- (q/width) 1))
       :y (q/constrain y 0 (- (q/height) 1))}))
