(ns primes.test.core
  (:use [primes.core] :reload-all)
  (:require [criterium.core])
  (:use [clojure.test])
  )

(deftest checkresult
  (is (= (take 1000 primes)
	 (take 1000 primes-simple)
	 (take 1000 primes-sieve))))

(def n 1000000)

(println "primes lazy mistake")
(time (take 10 (drop n primes)))

(println "primes")
(time (println (take 5 (drop n primes)) ))

(println "primes-simple")
(time (println (take 5 (drop n primes-simple)) ))

(println "primes-sieve")
(time (println (take 5 (drop n primes-sieve)) ))