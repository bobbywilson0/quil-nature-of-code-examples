(ns nature-of-code.introduction.07-exercise-1-3-walker-to-mouse.walker
  (:require [quil.core :as q]
            [quil.middleware :as m]))

  (defn render [x, y]
    (q/stroke 0)
    (q/point x, y))

  (defn dir [axis, value]
    (let [dir (- (eval (read-string (str "(quil.core/mouse-" (name axis) ")"))) value)]
     (if (not= dir 0)
       (/ dir (q/abs dir))
       dir)))

  (defn step [x, y]
    (let [r (q/random 1)
          xdir (if (< r 0.5)
                 (dir :x x)
                 (int (q/random -2 2)))
          ydir (if (< r 0.5)
                 (dir :y y)
                 (int (q/random -2 2)))]

      {:x (q/constrain (+ x xdir) 0 (- (q/width) 1))
       :y (q/constrain (+ y ydir) 0 (- (q/height) 1))}))

