package taskBD;

public enum Table {
    PARENT ("CREATE TABLE PARENT (" +
            "id_parent VARCHAR(50) NOT NULL," +
            "lastname VARCHAR(50) NOT NULL," +
            "firstname VARCHAR(50) NOT NULL," +
            "age INT NOT NULL" +
            ")"),
    CHILD ("CREATE TABLE CHILD (" +
            "id_child VARCHAR(50) NOT NULL," +
            "r_id_parent VARCHAR(50) NOT NULL," +
            "lastname VARCHAR(50) NOT NULL," +
            "firstname VARCHAR(50) NOT NULL," +
            "age INT NOT NULL" +
            ")");

    Table(String sql){
        this.sql = sql;
    }

    private String sql;

    public String getSql(){
        return this.sql;
    }
}
