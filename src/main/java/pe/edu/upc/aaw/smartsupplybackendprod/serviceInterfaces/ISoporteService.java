package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;



import pe.edu.upc.aaw.smartsupplybackendprod.entities.Soporte;

import java.util.List;

public interface ISoporteService {

    public void insert(Soporte support);
    public List<Soporte> list();
    public void delete(int idSupport);
    public Soporte listId(int idSupport);
    List<String[]> inciddenciasXMes();

}
