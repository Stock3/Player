package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IGenericProviderSql<T> {
    void execute(String procedureName, Object[] sqlParametres) throws SQLException;

    ResultSet getList(String procedureName, Object[] sqlParametres) throws SQLException;

}

