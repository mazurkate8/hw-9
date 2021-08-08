package countwords


import spock.lang.Specification

class CountWordsFromFileTest extends Specification {
    CountWordsFromFile countWordsFromFile;

    def setup() {
        countWordsFromFile = new CountWordsFromFile()
    }

    def "Читаю файл и считаю количество слов" (){
        given : "Читаю файл"
        countWordsFromFile.parseFile(new File("src/main/resources/count.txt"))

        expect: "Получаю мапу"
        countWordsFromFile.countMap.size() > 0
        countWordsFromFile.countMap.get("the") == 4
        countWordsFromFile.countMap.get("day") == 5
        countWordsFromFile.countMap.get("is") == 3
        countWordsFromFile.countMap.get("sunny") == 2
    }
}
