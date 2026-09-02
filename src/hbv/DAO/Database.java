package hbv.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Database {
    private DataSource dataSource = null;

    public Database() {
        create();
    }

    public Connection connect() throws SQLException {
        return dataSource.getConnection();
    }

    private synchronized void create() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:/comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}