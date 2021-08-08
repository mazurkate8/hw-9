import phoneparser.ParsePhoneNumber
import spock.lang.Specification

class ParsePhoneNumberTest extends Specification {
    private ParsePhoneNumber parsePhoneNumber

    def setup() {
        parsePhoneNumber = new ParsePhoneNumber()
    }

    def "Читаю файл и извлекаю номера телефонов, ожидается что хотя бы один номер попадает в список" () {
        given:
        parsePhoneNumber.parseFile(new File("src/main/resources/file.txt"))

        expect: "Номера добавились в список"
        parsePhoneNumber.getPhoneList().size() > 0
        parsePhoneNumber.getPhoneList().contains("987-123-4567")
        parsePhoneNumber.getPhoneList().contains("(123) 456-7890")
        !parsePhoneNumber.getPhoneList().contains("123 456 7890")
    }
}
