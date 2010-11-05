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
(time (take 10 (drop 100000 primes)))

(println "primes")
(time (sequence (take 5 (drop 5000000 primes)) ))

(println "primes-simple")
(time (sequence (take 5 (drop 5000000 primes-simple)) ))

(println "primes-sieve")
(time (sequence (take 5 (drop 5000000 primes-sieve)) ))