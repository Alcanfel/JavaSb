package taskBD;

public enum INSERT {
    IntoParent("INSERT INTO PARENT (id_parent, lastname, firstname, age) values (?,?,?,?) "),
    IntoChild("INSERT INTO CHILD (id_child, r_id_parent, lastname, firstname, age) values (?,?,?,?,?) ");
    INSERT(String sql){
        this.sql = sql;
    }

    private String sql;

    public String getSql(){
        return this.sql;
    }
}
