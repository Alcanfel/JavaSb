package taskBD;

public enum Select {
    ParentAndChild ("select p.lastname lastnameParent, p.firstname firstnameParent, p.age ageParent, ch.lastname lastnameChild, ch.firstname firstChild, ch.age ageChild from parent p, child ch\n" +
            "where p.id_parent = ch.r_id_parent");

    Select(String sql){
        this.sql = sql;
    }

    private String sql;

    public String getSql(){
        return this.sql;
    }
}
