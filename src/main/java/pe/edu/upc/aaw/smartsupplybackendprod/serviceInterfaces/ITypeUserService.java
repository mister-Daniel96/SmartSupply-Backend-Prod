package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;


import pe.edu.upc.aaw.smartsupplybackendprod.entities.TypeUser;

import java.util.List;

public interface ITypeUserService  {

    public void insert(TypeUser typeUser);
    public List<TypeUser>list();
    public void delete(Long idTypeUser);
    public TypeUser listId(Long idTypeUser);
}
