(ns primes.test.core
  (:use [primes.core] :reload-all)
  (:use [criterium.core])
										;(:use [clojure.test])
  )

;(deftest checkresult
;  (is (= (take 1000 primes)
;	 (take 1000 primes-simple)
;	 (take 1000 primes-sieve))))


(println "primes")
(time (println (take 5 (drop 1000000 primes)) ))

(println "primes")
(time (take 10 (drop 1000000 primes)) )

(println "primes-simple")
(time (println (take 5 (drop 1000000 primes-simple)) ))

(println "primes-sieve")
(time (println (take 5 (drop 1000000 primes-sieve)) ))