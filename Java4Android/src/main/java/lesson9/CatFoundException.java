package lesson9;

import java.io.IOException;

public class CatFoundException extends IOException {

    public CatFoundException() {
        super("Котам здесь не рады!");
    }

    public CatFoundException(int i) {
        super(String.format("Кот прокрался под номером %d на вечеринку животных", i));
    }
}
