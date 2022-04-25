package product.services.Role;

import data.Path;
import product.config.CSVUtils;
import product.model.Payment;
import product.model.Role;
import product.model.RoleName;

import java.util.ArrayList;
import java.util.List;

public class IRoleServiceIMPL implements IRoleService{
    List<Role> roleList = new ArrayList<>();
    public static  String PATH_ROLE = Path.PATH + "role.csv";
    public static String path = PATH_ROLE;
    @Override
    public List<Role> findAll() {
        if(roleList.size()>=2){
            return roleList;
        } else {
            roleList.add(new Role(1,RoleName.ADMIN));
            roleList.add(new Role(2,RoleName.USER));
        }
        CSVUtils.write(path,roleList);
        return roleList;
    }
    @Override
    public void save(Role role) {
        roleList.add(role);

    }

    @Override
    public Role findByID(int id) {
        return null;
    }

    @Override
    public Role findByName(RoleName name) {
        findAll();
        for (int i = 0; i <roleList.size();i++) {
            if (name == roleList.get(i).getName()){
                return roleList.get(i);
            }
        } return null;
    }
}
