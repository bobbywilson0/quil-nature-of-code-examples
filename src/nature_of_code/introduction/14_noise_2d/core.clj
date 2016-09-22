(ns nature-of-code.introduction.14-noise-2d.core
  (:require [quil.core :as q])
  (:import [processing.core]))

(defn setup []
  (q/background 0)
  (q/no-loop))

(def increment 0.02)

(defn bright [xoff yoff]
  (* (q/noise xoff yoff) 255))

(defn draw []
  (let [pxs (q/pixels)]
    (doseq [x (range 0 (q/width)) :let [xoff (* x increment)]]
      (doseq [y (range 0 (q/height)) :let [yoff (* y increment)]]
        (aset-int
          pxs
          (+ x (* y (q/width)))
          (q/color (bright xoff yoff)))
        (q/update-pixels)))))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :size [640 320])