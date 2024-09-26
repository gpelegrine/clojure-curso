(ns clojure-curso.core
  (:gen-class))

  (def tasks (atom [])) ;;tasks: É um atom que guarda uma lista de tarefas.

  (defn add-task [task]
    (swap! tasks conj task) ;;swap!: É uma função que permite atualizar o valor de um atom.
    (println "Task added:" task))
  
  (defn list-tasks []
    (println "Your tasks:")
    ;;doseq: É um loop que itera sobre cada elemento de uma coleção.
    ;;@tasks: O @ é usado para acessar o valor armazenado dentro do atom tasks.
      (doseq [task @tasks] 
      (println "- " task)))
  ;;Então, (doseq [task @tasks] (println "- " task)) significa: "Para cada task na lista de tasks, imprima "- " seguido da task.

  (defn prompt-user []
    (println "Choose an option:")
    (println "1. Add task")
    (println "2. List tasks")
    (println "3. Exit")
    (flush)
    ;;(flush): Garante que o buffer de saída do console seja esvaziado imediatamente, fazendo com que as saídas apareçam no terminal sem demora. Exemplo: sem flush, o usuário pode não ver imediatamente a mensagem exibida pelo println.
    (Integer/parseInt (read-line)))
    ;; (read-line): Captura a entrada do usuário como uma string. Exemplo: se o usuário digitar 1, retorna "1"
    ;; (Integer/parseInt ...): Converte a string retornada por read-line em um número inteiro. Exemplo: converte "1" para 1. Necessário para comparações numéricas no programa.
  
  (defn -main []
    (loop []
      (let [choice (prompt-user)]
      ;;[choice (prompt-user)]: Chama a função prompt-user e armazena o valor retornado na variável choice.
        (cond
        ;;O que é: cond é uma forma de estrutura condicional que permite avaliar múltiplas expressões. É semelhante ao if-else if em outras linguagens de programação.
        ;; O que é: do é usado para agrupar várias expressões que devem ser executadas em sequência. Em Clojure, se você quiser executar mais de uma expressão dentro de um bloco condicional, você pode usar do.  
        (= choice 1) (do
                         (println "Enter a task:")
                         (flush)
                         (add-task (read-line))
                         (recur))
          (= choice 2) (do
                         (list-tasks)
                         (recur))
          (= choice 3) (println "Goodbye!")
          :else (do
                  (println "Invalid option. Try again.")
                  (recur))))))
          ;;Se você não usar recur, o loop não irá reiniciar e o programa não voltará para o início para esperar por novas entradas do usuário
