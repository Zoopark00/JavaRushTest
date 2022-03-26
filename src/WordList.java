import java.util.HashSet;

public class WordList {
    //Создаем список слов для сравнения
    public static HashSet<String> GetList(){
        HashSet<String> wordList = new HashSet<>();
        wordList.add("мой");
        wordList.add("дядя");
        wordList.add("она");
        wordList.add("что");
        wordList.add("где");
        wordList.add("когда");
        wordList.add("или");
        wordList.add("кто");
        wordList.add("привет");
        wordList.add("слово");



        return  wordList;
    }
}
