package GraphicInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class NumberRepository {
    public List<Numar> getNumber() throws SQLException {
        try(Connection connection=DatabaseConfiguration.getConnection()){
            String number="SELECT id,Numar FROM matematica";
            Statement statement=connection.createStatement();
            statement.execute(number);

            ResultSet resultSet =statement.executeQuery(number);
            List<Numar> listaNumar=new LinkedList<>();
            while(resultSet.next()){
                Numar numar=new Numar();
                numar.setId(resultSet.getInt("id"));
                numar.setNumber(resultSet.getInt("Numar"));
                listaNumar.add(numar);
            }
            return listaNumar;
        }
    }
}
