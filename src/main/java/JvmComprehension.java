public class JvmComprehension {     //0 Загрузили данные о классе в Metaspace Memory

    public static void main(String[] args) {    // 0.1 В момент вызова создается фрейм main в Stack Memory
        int i = 1;                      // 1 Иницилизация i = 1 в Stack Memory
        Object o = new Object();        // 2 Выделение места для Object в heap(куче), o -> Stack Memory
        Integer ii = 2;                 // 3 ii -> Stack Memory, 2 -> heap
        printAll(o, i, ii);             // 4 В момент вызова создается фрейм printAll в Stack Memory

        System.out.println("finished"); // 7 В момент вызова создается фрейм println в Stack Memory
                                        // где будет ссылка на String "finished"
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 Выделение места для Integer в heap(куче),
                                                    // uselessVar -> Stack Memory
                                                    // после выполнения метода ссылка будет уничтожена сборщиком мусора
        System.out.println(o.toString() + i + ii);  // 6 В момент вызова создается фрейм в Stack Memory с ссылками
                                                    // на о,i, ii
    }
}
