(ns primes.core)

(def primes
     (concat
      [2 3 5 7]
      (lazy-seq
       (let [primes-from
             (fn primes-from [n [f & r]]
               (if (some #(zero? (rem n %))
                         (take-while #(<= (* % %) n) primes))
                 (recur (+ n f) r)
                 (lazy-seq (cons n (primes-from (+ n f) r)))))
             wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2
                           6 4 6 8 4 2 4 2 4 8 6 4 6 2 4 6
                           2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
         (primes-from 11 wheel)))))

(def primes-simple
     (concat
      [2 3 5 7]
      (lazy-seq
       (let [primes-from
             (fn primes-from [n]
               (if (some #(zero? (rem n %))
                         (take-while #(<= (* % %) n) primes-simple))
                 (recur (+ n 1))
                 (lazy-seq (cons n (primes-from (+ n 1))))))]
         (primes-from 11)))))

(def primes-sieve
     (concat
      [2 3 5 7]
      (lazy-seq
       (let [primes-from
             (fn primes-from [n composites]
               (if (= (ffirst composites) n)
                 (recur (+ n 1)
                        (merge
                         (dissoc composites n)
                         (zipmap (map +
                                      (cycle [n])
                                      (composites n))
                                 (map #(concat (composites (+ n %))
                                               [%])  
                                      (composites n)))))
                 (lazy-seq
                  (cons n
                        (primes-from (+ n 1)
                                     (assoc
                                         composites
                                       (* n n)
                                       (concat (composites (* n n)) [n])))))))]
         (primes-from 11 (sorted-map 12 [2 3],
                                     14 [7],
                                     15 [5] ))))))






