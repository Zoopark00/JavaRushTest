import java.util.HashSet;

public class WordList {
    //создаем список слов для сравнения
    public static HashSet<String> GetList(){
        HashSet<String> wordList = new HashSet<>();
        wordList.add("мой");
        wordList.add("она");
        wordList.add("дядя");
        wordList.add("что");
        wordList.add("где");
        wordList.add("когда");
        wordList.add("привет");
        wordList.add("мир");
        wordList.add("слово");
        wordList.add("проверка");



        return  wordList;
    }
}
