(ns nature-of-code.introduction.14-noise-2d.core
  (:require [quil.core :as q])
  (:import [processing.core]))

(defn setup []
  (q/background 255)
  (q/no-loop))

(defn draw []
  (let [pxs (q/pixels)]
    (doseq [x (range 0 (q/width))
            y (range 0 (q/height))]
      (let [bright (q/map-range (q/noise (* x 0.05) (* y 0.05)) 0 1 0 255)]
        (aset-int pxs (+ x (* y (q/width))) (q/color bright)))))
  (q/update-pixels))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :size [640 320])
