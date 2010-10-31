(def composites (sorted-map 12 [2,3], 14 [7], 15 [5]))
(def n 12)

(merge-with cons
						(dissoc composites n)
						(zipmap (map + (cycle [n]) (composites n)) (composites n)))