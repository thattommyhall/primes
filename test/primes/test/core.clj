(ns primes.test.core
  (:use [primes.core] :reload-all)
  (:use [clojure.test])
					;(:use [criterium.core])
)

(deftest checkresult
  (is (= (take 1000 primes)
	 (take 1000 primes-simple)
	 (take 1000 primes-sieve))))




