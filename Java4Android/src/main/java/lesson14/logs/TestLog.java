package lesson14.logs;

import java.io.IOException;
import java.util.logging.*;

public class TestLog {

    protected static final Logger logger = Logger.getLogger("TestLog");

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);
        Handler handler = new FileHandler("src/main/resources/logs/myLogs.log");
        logger.addHandler(handler);
        logger.getHandlers()[0].setLevel(Level.ALL);
//        handler.setFormatter(new SimpleFormatter());
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.log(Level.SEVERE, "Логирование S");
        logger.log(Level.INFO, "Логирование I");
        logger.warning("Логирование W");
        logger.config("Логирование C");

    }

    //OFF
    //SEVERE
    //WARNING
    //INFO
    //CONFIG
    //FINE(3)
    //ALL
}
