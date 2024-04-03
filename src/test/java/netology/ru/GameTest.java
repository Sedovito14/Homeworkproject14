package netology.ru;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player petr = new Player(123, "Пётр",120);
        Player yasya = new Player(124,"Яся",180);
        Game game = new Game();

        game.register(petr);
        game.register(yasya);
        int actual = game.round("Пётр", "Яся");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player petr = new Player(123, "Пётр",120);
        Player yasya = new Player(124,"Яся",100);
        Game game = new Game();

        game.register(petr);
        game.register(yasya);
        int actual = game.round("Пётр", "Яся");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player petr = new Player(123, "Пётр",100);
        Player yasya = new Player(124,"Яся",100);
        Game game = new Game();

        game.register(petr);
        game.register(yasya);
        int actual = game.round("Пётр", "Яся");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player yasya = new Player(1,"Яся",100);
        Game game = new Game();

        game.register(yasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Жора", "Яся")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player yasya = new Player(1,"Яся",100);
        Game game = new Game();

        game.register(yasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Яся", "Жора")
        );
    }
}
