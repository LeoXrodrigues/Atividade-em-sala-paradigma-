(ns atividade.atividade_sala)

(defn -main []
    (println "Informe a quantidade de alunos: ")
    (let [qtdAlunos (Integer/parseInt (read-line))]
        (loop [i 0 soma 0 aprovados 0]
            (if (< i qtdAlunos)
                (do
                    (println (str "Informe nome do aluno:"))
                    (let [nome (read-line)]
                        (println "Nota:")
                        (let [nota (Integer/parseInt (read-line))
                              conceito (cond
                                          (> nota 100) "Nota invalida"
                                          (>= nota 90) "A"
                                          (>= nota 80) "B"
                                          (>= nota 70) "C"
                                          (>= nota 60) "D"
                                          :else "F")]
                            (println (str "Nome: " nome " | Conceito: " conceito))
                            (recur (inc i)
                                   (+ soma nota)
                                   (if (>= nota 60) (inc aprovados) aprovados))
                        )
                    )
                )

                (let [media (/ soma qtdAlunos)]
                    (println (str "Média da turma: " media))
                    (println (str "Aprovados: " aprovados))
                    (println "Desempenho geral:"
                        (cond
                            (>= media 80) "Turma excelente!"
                            (>= media 60) "Bom desempenho!"
                            :else "E necessario melhorar!"
                        )
                    )
                )
            )
        )
    )
)