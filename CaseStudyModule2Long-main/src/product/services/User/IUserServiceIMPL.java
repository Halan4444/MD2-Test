package product.services.User;

import data.Path;
import product.config.CSVUtils;
import product.model.Product;
import product.model.Status;
import product.model.User;

import java.util.ArrayList;
import java.util.List;

public class IUserServiceIMPL implements IUserService{
    public static List<User> userList = new ArrayList<>();
    public static String PATH_USER = Path.PATH + "user.csv";
    public static  String path = PATH_USER;

    public List<User> findAll(){
        CSVUtils.write(path,userList);
        return userList;
    }

    public void add(User newUser) {
        userList.add(newUser);
        CSVUtils.write(path, userList);
    }

    public void update(int id, User updateUser) {
        getUsers();
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId() == id){
                userList.set(i,updateUser);
                CSVUtils.write(path,userList);
            }
        }
        }
    @Override
    public User findById(int id) {
        for (int i=0; i<userList.size();i++) {
            if (userList.get(i).getId() == id) {
                return userList.get(i);
            }
        } return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> newUserList = new ArrayList<>();
        List<String> reads = CSVUtils.read(path);
        for (String read : reads) {
            newUserList.add(new User(read));
        }
        return userList = newUserList;
    }

    @Override
    public boolean existedByUsername(String username) {
        getUsers();
        for (User user: userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        } return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i =0; i < userList.size();i++) {
            if (username.equals(userList.get(i).getUsername())&&password.equals(userList.get(i).getPassword())) {
                return true;
            }
        } return false;
    }




    public User findByUsername (String username){
        for (int i =0; i<userList.size();i++){
            if (username.equals(userList.get(i).getUsername())) {
                return userList.get(i);
            }
        }
        return null;
    }



}




