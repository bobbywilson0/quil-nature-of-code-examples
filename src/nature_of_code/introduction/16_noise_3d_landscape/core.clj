(ns nature-of-code.introduction.16_noise_3d_landscape.core
  (:require [quil.core :as q]
    [quil.middleware :as m])
  (:import [processing.core]))

(defn setup []
  {:scale 20 :width 800 :height 400 :z [] :z-offset 0.01 :theta 0.0})

(defn calculate [state]
  (let [scale (:scale state) rows (/ (:width state) scale) cols (/ (:height state) scale)]
    (mapv
      (fn [y]
        (mapv
          (fn [x]
            (q/map-range (q/noise (* y 0.1) (* x 0.1) (:z-offset state)) 0 1 -120 120))
          (range 0 rows)))
      (range 0 cols))))

(defn render [state]
  (doseq [x (range 0 (- (count (:z state)) 1))]
    (doseq [y (range 0 (- (count (get-in state [:z x])) 1))]
      (q/stroke 0)
      (q/fill 100 100)
      (q/push-matrix)
      (q/begin-shape :quads)
      (q/translate
        (- (* x (:scale state)) (/ (:width state) 2))
        (- (* y (:scale state)) (/ (:height state) 2))
        0)
      (q/vertex 0 0 (get-in state [:z x y]))
      (q/vertex (:scale state) 0 (get-in state [:z (+ x 1) y]))
      (q/vertex (:scale state) (:scale state) (get-in state [:z (+ x 1) (+ y 1)]))
      (q/vertex 0 (:scale state) (get-in state [:z x (+ y 1)]))
      (q/end-shape)
      (q/pop-matrix))))


(defn draw [state]
  (q/background 255)
  (q/push-matrix)
  (q/translate (/ (:width state) 2) (+ (/ (:height state) 2) 20) -160)
  (q/rotate-x (/ (. Math PI) 3))
  (q/rotate-z (:theta state))
  (render state)
  (q/pop-matrix))

(defn update-screen [state]
  (-> state
    (assoc :z (calculate state))
    (update :z-offset + 0.01)
    (update :theta + 0.0025)))

(q/defsketch nature-of-code
  :setup setup
  :draw draw
  :update update-screen
  :renderer :p3d
  :middleware [m/fun-mode]
  :size [800 400])