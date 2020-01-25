package taskBD;

import java.sql.*;

public class BDConnectionSS {
    private Connection connection;

    private static BDConnectionSS instance = null;

    public static synchronized BDConnectionSS getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null){
            instance = new BDConnectionSS("com.microsoft.sqlserver.jdbc.SQLServerDriver","jdbc:
;databaseName=J;user=;password=");
        } return instance;
    }

    public BDConnectionSS(String driver,String conString) throws ClassNotFoundException, SQLException {
        if (this.connection == null){
            Class.forName(driver);
            this.connection = DriverManager.getConnection(conString);
        }
    }

    public ResultSet select(String q) throws SQLException {
        Statement stmt = connection.createStatement(); // Возвращает объект на основе которого можно формировать запросы к БД
        ResultSet rs = stmt.executeQuery(q);
        return rs;
    }
    public void insertParent(String q, String uuid, String lastName, String firstName, String age) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement(q);
        stmt.setString(1, uuid);
        stmt.setString(2, lastName);
        stmt.setString(3, firstName);
        stmt.setInt(4, Integer.parseInt(age));
        stmt.execute();
    }
    public void insertChild(String q, String uuidChild, String uuidParent, String lastName, String firstName, String age) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement(q);
        stmt.setString(1, uuidChild);
        stmt.setString(2, uuidParent);
        stmt.setString(3, lastName);
        stmt.setString(4, firstName);
        stmt.setInt(5, Integer.parseInt(age));
        stmt.execute();
    }

    public void update(String q) throws SQLException{

    }

    public void create(String q) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement(q);
        stmt.execute();
    }

    public void close() throws SQLException{
        if(this.connection!=null) if (!this.connection.isClosed()) this.connection.close();
    }


}
