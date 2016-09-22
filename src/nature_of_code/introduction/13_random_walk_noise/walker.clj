(ns nature-of-code.introduction.13-random-walk-noise.walker
  (:require [quil.core :as q]))


(def walker
  (atom
    {:tx 0
     :ty 10000
     :x nil
     :y nil
     :prev-x nil
     :prev-y nil}))

(defn render []
  (q/stroke 255)

  (q/line (@walker :prev-x) (@walker :prev-y) (@walker :x) (@walker :y)))

(defn step []
  (swap! walker assoc :prev-x (@walker :x))
  (swap! walker assoc :prev-y (@walker :y))

  (swap! walker assoc :x (q/map-range (q/noise (@walker :tx)), 0, 1, 0, (q/width)))
  (swap! walker assoc :y (q/map-range (q/noise (@walker :ty)), 0, 1, 0, (q/height)))

  (swap! walker assoc :tx (+ (@walker :tx) 0.01))
  (swap! walker assoc :ty (+ (@walker :ty) 0.01)))
