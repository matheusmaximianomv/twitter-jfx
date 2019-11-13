package app.controllers;

import app.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Max
 */
public class ListUsers {
    
    private static List<User> registeredUsers = new ArrayList<User>();
    private int records = 0;
    
    public void addUser(User user) {
        registeredUsers.add(user);
        records++;
    }
    
    public List<User> getUsers() {
        return registeredUsers;
    }
    
    public int getRecords() {
        return records;
    }
    
}
