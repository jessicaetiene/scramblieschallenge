(ns scramblies-api.service)


(defn- scramble? [word1 word2]
  ; Returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false
  (let [
        char-frequency-word1 (frequencies word1)
        char-frequency-word2 (frequencies word2)
        ]

    (every? true?
            (for [char-frequency char-frequency-word2]
              (let [frequency (get char-frequency-word1 (key char-frequency))]
                (if frequency
                  (>= frequency (val char-frequency))
                  false))))))

(defn check-words [word1 word2]
  ; If the two word are valid calls the method scramble?, otherwise returns a message error
  (if
    (and (re-matches #"[a-z]*" word1) (re-matches #"[a-z]*" word2))
      {:word1 word1, :word2 word2, :scramble (scramble? word1 word2)}
      {:message "Only lower case letters will be used (a-z). No punctuation or digits will be included."}))



