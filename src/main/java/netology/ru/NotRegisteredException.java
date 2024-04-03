package netology.ru;
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок с именем" + name + "не найден");
    }
}
