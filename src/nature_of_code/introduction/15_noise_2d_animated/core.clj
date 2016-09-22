(ns nature-of-code.introduction.15-noise-2d-animated.core
  (:require [quil.core :as q]
    [quil.middleware :as m])
  (:import [processing.core]))

(defn setup []
  (q/background 0)
  {:step 0})

(def increment 0.02)

(defn bright [xoff yoff anim]
  (* (q/noise xoff yoff anim) 255))

(defn draw [state]
  (doseq [x (range 0 (q/width)) :let [xoff (* x increment)]]
    (doseq [y (range 0 (q/height)) :let [yoff (* y increment)]]
      (q/set-pixel x y
        (q/color (bright xoff yoff (:step state)))))))

(defn update [state]
  (update-in state [:step] inc))

(q/defsketch nature-of-code
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode]
  :size [640 320])