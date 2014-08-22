(ns nature-of-code.introduction.02-random-walk-traditional.walker
  (:require [quil.core :as q]
            [quil.middleware :as m]))

  (defn render [x, y]
    (q/stroke 0)
    (q/point x, y))

  (defn step [x, y]
    (let [choice (int (q/random 4))
          new-x (int (+ x (- (q/random 3) 1)))
          new-y (int (+ y (- (q/random 3) 1)))]
      {:x (q/constrain new-x 0 (- (q/width) 1))
       :y (q/constrain new-y 0 (- (q/height) 1))}))
