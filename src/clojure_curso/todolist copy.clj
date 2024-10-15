(ns clojure-curso.todolist
  (:gen-class))

(def tasks (atom []))

(defn add-task 
  [task]
  (swap! tasks conj task)
  (println "Task added:" task))

(defn list-task []
  (println "Your tasks:")
  (->> @tasks
       (doseq [task]
         (println "- " task))
       (println "\n")))

(defn prompt-user []
  (println "\n")
  (println "Choose an option:")
  (println "1. Add to task")
  (println "2. List tasks")
  (println "3. Exit")
  (flush)
  (-> (read-line)
      (Integer/parseInt))
  (println "\n"))

(defn -main []
  (loop []
    (let [choice (prompt-user)]
      (cond
        (= choice 1) (do
            (println "Enter a task:")
            (flush)
            (-> (read-line)
                (add-task))
            (recur))
        (= choice 2) (do
            (list-task)
            (recur))
        (= choice 3) (println "Goodbye!")
        :else (do
            (println "Invalid option. Try again.")
            (recur))))))
