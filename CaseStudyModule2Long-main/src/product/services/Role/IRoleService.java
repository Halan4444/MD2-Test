package product.services.Role;

import product.model.RoleName;
import product.model.Role;
import product.services.IGenericService;

public interface IRoleService extends IGenericService<Role> {
    Role findByName (RoleName name);
}
