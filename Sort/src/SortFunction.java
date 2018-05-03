import java.util.*;

public class SortFunction {

    //Групировка слов входной строки по первой букве
    public static void SortString () {
        //переменная для сохранения слова
        String word = "";
        //запускаем цикл по строке
        for (int i = 0; i < Variables.inputString.length(); i++) {
            if (Variables.inputString.charAt(i) != ' ')
                //если взятый символ не равен пробелу, то добавляем его в переменную слова
                word += Variables.inputString.charAt(i);
            else {
                //иначе записываем первый символ слова, как ключ
                String key = word.charAt(0) + "";
                //проверяем на наличие такого ключа в карте
                if (!Variables.sortedString.containsKey(key)) {
                    //если такого ключа нет, то создаем новый список слов по данному ключу, и добавляем туда наше слово
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(word);
                    Variables.sortedString.put(key + "", list);
                } else
                    //иначе берем лист по этому ключу, и добавляем туда наше слово
                    Variables.sortedString.get(key).add(word);
                //обнуляем слово
                word = "";
            }
        }
        //делаем тоже самое в конце строки (т.к. нет пробела в конце строки)
        String key = word.charAt(0) + "";
        if (!Variables.sortedString.containsKey(key)) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(word);
            Variables.sortedString.put(key + "", list);
        } else
            Variables.sortedString.get(key).add(word);
    }

    //Сортировка списков слов по правилу
    public static void SortList () {
        //берем все ключи
        for (String key : Variables.sortedString.keySet()) {
            //для каждого ключа берем его список слов
            ArrayList<String> list = Variables.sortedString.get(key);
            //реализуем сортировку отдельного списка
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String word1, String word2) {
                    //если длина слов разная все просто
                    int res = word2.length() - word1.length();
                    //если они равны, то делаем соритровку по алфавиту
                    if (res == 0) {
                        for (int i = 0; i < word1.length(); i++) {
                            char char1 = word1.charAt(i);
                            char char2 = word2.charAt(i);
                            if(char1 < char2)
                                res = -1;
                            else
                                res = 1;
                        }
                    }
                    return res;
                }
            });
        }
    }

}
