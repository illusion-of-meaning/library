import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main
{
    private final static int SHELF = 5;
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("Половина верблюда");
        books.add("Повелитель мух");
        books.add("Лавка древностей");
        books.add("Три чашки чая");
        books.add("Как важно быть серьезным");
        books.add("Дюна");
        books.add("Азазель");
        
        Map<Integer, List<String>> bookMap = bookShelves(books);
        bookMap.forEach((K, V) -> {
            System.out.println(K + ":");
            V.forEach(s -> System.out.println("\t" + s));
        });
    }

    private static Map bookShelves(List<String> books) {
        int ind = 0;
        int countShelf = books.size() / SHELF;
        int rem = books.size() % SHELF;
        Collections.sort(books);
        
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for (int i = 1; i <= SHELF; i++) {
            int countCopy = ind + countShelf;
            if (rem > 0) {
                countCopy++;
                rem--;
            }
            resultMap.put(i, books.subList(ind, countCopy));
            ind = countCopy;
        }

        return resultMap;
    }
}
