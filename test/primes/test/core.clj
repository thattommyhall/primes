(ns primes.test.core
  (:use [primes.core] :reload-all)
  (:require [criterium.core])
  (:use [clojure.test])
  )

(deftest checkresult
  (is (= (take 1000 primes)
	 (take 1000 primes-simple)
	 (take 1000 primes-sieve))))

(println "primes lazy mistake")
(criterium.core/bench (take 10 (drop 100000 primes)) )

(println "primes")
(criterium.core/bench (println (take 5 (drop 100000 primes)) ))

(println "primes-simple")
(criterium.core/bench (println (take 5 (drop 100000 primes-simple)) ))

(println "primes-sieve")
(criterium.core/bench (println (take 5 (drop 100000 primes-sieve)) ))