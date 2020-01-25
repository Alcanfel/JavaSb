package ReflectionAndAnnotation.Task1;

import java.util.regex.Matcher;

public class User {

    @Parse(name = "Session", visibility = true)
    private Integer session;
    @Parse(name = "DomainName", visibility = false)
    private String domain;
    @Parse(name = "LOGIN")
    public String login;
    @Parse(property = true, name = "FIO",visibility = true)
    public String fio;
    @Parse(name = "tab", property = false)
    public Integer tab;

    public User(){

    }

    public User(String domain, String login, String fio, Integer tab){
        this.session = getSessionInt();
        this.domain = domain;
        this.login = login;
        this.fio = fio;
        this.tab = tab;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getTab() {
        return tab;
    }

    public void setTab(Integer tab) {
        this.tab = tab;
    }

    public User(Integer session, String domain, String login, Integer tab) {
        this.session = session;
        this.domain = domain;
        this.login = login;
        this.tab = tab;
    }

    public User(String login, String fio,Integer tab) {
        this.session = getSessionInt();
        this.login = login;
        this.fio = fio;
        this.tab = tab;
    }

    public User(String login, Integer tab) {
        this.session = getSessionInt();
        this.login = login;
        this.tab = tab;
    }

    private Integer getSessionInt(){
        return (int) (Math.random()*1123);
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
