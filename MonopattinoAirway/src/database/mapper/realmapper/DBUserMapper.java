package database.mapper.realmapper;

import database.cache.UserCache;
import database.interfaces.mapperinterfaces.UserMapper;
import database.people.User;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUserMapper extends ConcreteMapper implements UserMapper{
    private final String tableName;
    
    public DBUserMapper(String userTableName) {
        super();
        tableName = userTableName;
        cache = new UserCache();
    }
    
    @Override
    protected Object getFromCache(String id) {
        return cache.get(id);
    }
    
    @Override
    protected User getFromStorage(String username) {
        User u = null;
        String query = buildSelectQuery(username);
        try {
            ResultSet data = con.createStatement().executeQuery(query);
            if(data.next()) {
                String name = data.getString("NAME");
                String surname = data.getString("SURNAME");
                String cf = data.getString("CF");
                //username = data.getString("USENAME");
                String psw = data.getString("PSW");
                String email = data.getString("EMAIL");
                u = new User(name, surname, cf, username, psw, email);
            }
        }
        catch(SQLException exc) {
            System.err.println(exc.getMessage());
        }
        return u;
    }
    
    @Override
    protected String buildSelectQuery(String id) {
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(tableName).append(" WHERE username = '").append(id).append("'");
        return str.toString();
    }
    
    @Override
    protected String buildSaveQuery(Object arg) {
        User u = (User)arg;
        StringBuilder str = new StringBuilder();
        String name = u.getName();
        String surname = u.getSurname();
        String cf = u.getCf();
        String username = u.getUsername();
        String psw = u.getPsw();
        String email = u.getEmail();
        str.append("INSERT INTO ").append(tableName)
                .append(" VALUES ('").append(username).append("', '").append(name).append("', '")
                .append(surname).append("', '").append(cf).append("', '").append(psw).append("', '")
                .append(email).append("');");
        return str.toString();
    }
}

