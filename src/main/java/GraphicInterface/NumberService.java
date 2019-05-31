package GraphicInterface;

import java.sql.SQLException;
import java.util.List;

public class NumberService {
    NumberRepository numberRepository=new NumberRepository();

    public List<Numar> getNumber() throws SQLException {
        return numberRepository.getNumber();
    }
}
