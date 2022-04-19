package product.services.UserPrincipal;

import data.Path;
import product.config.CSVUtils;
import product.model.User;
import product.model.UserPrincipal;

import java.util.ArrayList;
import java.util.List;

public class IUserPrincipalIMPL {
    public static List<UserPrincipal> userPrincipalList = new ArrayList<>();
    public static String PATH_USER = Path.PATH + "user.csv";
    public static  String path = PATH_USER;

    public List<UserPrincipal> getUserPrincipal () {
        List<UserPrincipal> newUserPrincipalList = new ArrayList<>();
        List<String> reads = CSVUtils.read(path);
        for (String read : reads) {
            newUserPrincipalList.add(new UserPrincipal(read));
        }
        return userPrincipalList = newUserPrincipalList;

    }


    public List<UserPrincipal> findAll(){
        CSVUtils.write(path,userPrincipalList);
        return userPrincipalList;
    }

    public void add(UserPrincipal newUserPrincipal) {
        userPrincipalList.clear();
        userPrincipalList.add(newUserPrincipal);
        CSVUtils.write(path, userPrincipalList);
    }

    public UserPrincipal findById(int id) {
        for (int i=0; i<userPrincipalList.size();i++) {
            if (userPrincipalList.get(i).getId() == id) {
                return userPrincipalList.get(i);
            }
        } return null;
    }

}
