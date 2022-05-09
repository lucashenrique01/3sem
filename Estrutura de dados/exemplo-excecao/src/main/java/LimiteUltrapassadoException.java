import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LimiteUltrapassadoException extends Exception{

    String data;

    public LimiteUltrapassadoException(String s) {
        super(s);

        this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
