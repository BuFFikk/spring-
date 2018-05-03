import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main (String[] args) {

        //Выведем исходную строку
        System.out.println("Исходная строка: " + Variables.inputString);

        //Сделаем сортировку
        SortFunction.SortString();
        SortFunction.SortList();

        // Получаем набор элементов
        Set<Map.Entry<String, ArrayList<String>>> set = Variables.sortedString.entrySet();
        // Отобразим набор
        System.out.println("Получившаяся строка: ");
        for (Map.Entry<String, ArrayList<String>> sortedString : set) {
            System.out.print(sortedString.getKey() + ": ");
            System.out.println(sortedString.getValue());
        }

    }

}
