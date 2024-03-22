package aan.edificaapi.igreja;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DadosCadastroIgrejaTest {

    @Test
    void whenMascaraDigitacaoTelefoneObedecida() {
        Pattern pattern = Pattern.compile("^\\(?([0-9]{2})\\)?( ?)([0-9]{5})\\-?([0-9]{4})$");
        Matcher matcher = pattern.matcher("(21) 98978-5527");
        assertTrue(matcher.matches());
    }
}