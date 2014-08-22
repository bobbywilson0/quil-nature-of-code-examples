(ns nature-of-code.introduction.08-figure-1-2-bell-curve.core
  (:require [quil.core :as q]))

(defn setup []
  (q/smooth))



(defn draw []
  (q/background 255)
  (let [heights (map-indexed (fn [i, height]
           (let [e 2.71828183
                 m 0
                 sd (q/map-range (q/mouse-x), 0, (q/width), 0.4, 2)
                 xcoord (q/map-range i, 0, (q/width) -3, 3)
                 sq2pi (q/sqrt (* 2 q/PI))
                 xmsq (* -1 (- xcoord m) (- xcoord m))
                 sdsq (* sd sd)]
            (* (/ 1 (* sd sq2pi)) (Math/pow e (/ xmsq sdsq)))))
            (vec (repeat (q/width) 0)))]

    (q/stroke 0)
    (q/stroke-weight 2)
    (q/no-fill)
    (q/begin-shape)
    (dorun (map-indexed
      (fn [i, height]
        (let [x i
              y (q/map-range height, 0, 1, (- (q/height) 2), 2)]
          (q/vertex x, y)))
      heights))
    (q/end-shape)))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :size [400 200])
