(ns clojure_curso.aula4)


(defn discounted-value
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(discounted-value (fn [valor-bruto] (> valor-bruto 100)) 110)

(discounted-value (fn [v] (> v 100)) 110)

(discounted-value #(> % 100) 110) ;; Função anônima (lambda)
 
;;

(defn some-one
  [value]
  (+ value 1))

  (println (update price 0 some-one))

  ;;

  (def price [30 700 1000])

  (defn aplica-desconto?
  [value]
  (> value 100))

(defn valor-descontado
  [value]
  (if (aplica-desconto? value)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* value taxa-de-desconto)]
      (- value desconto))
    value))

(println (map valor-descontado price)) ;; O desconto será aplicado para todos os preços do array;


(println (map valor-descontado (filter aplica-desconto? price)))

(println (filter aplica-desconto? price))

(valor-descontado 120)

(println (reduce + price))

;;

(defn somando 
  [value1 value2]
(println "somando" value1 "+" value2)
  (+ value1 value2))

(println (reduce somando price))

;;

(def estoque {"mochila" 10, "camiseta" 5})

(def estoque { :mochila 10, :camiseta 5 }) ;; Jeito correto de fazer.

(println estoque)

(println "Temos" (count estoque) "elementos") ;; Temos 2 elementos
(println "Chaves são:" (keys estoque)) ;; Chaves são: (mochila camiseta)
(println "Valores são:" (vals estoque)) ;; Valores são: (10 5)

(println (assoc estoque :blusa 8))
(println (update estoque :mochila inc))

(defn tirando-um 
  [value]
  (println "Tirando um de:" value)
  (- value 1))

(println (update estoque :mochila tirando-um))

(println (update estoque :mochila #(- % 1))) ;;Lambdas

(println (dissoc estoque :mochila))

;;

(def pedido {:mochila {:quantidade 4, :preço 89}
             :camiseta {:quantidade 2, :preço 59}})

(println pedido)

(def pedido (assoc pedido :calça {:quantidade 6, :preço 120}))

(println pedido)

(println (pedido :mochila)) ;; {:quantidade 4, :preço 89}
(println (get pedido :mochila)) ;; {:quantidade 4, :preço 89}








