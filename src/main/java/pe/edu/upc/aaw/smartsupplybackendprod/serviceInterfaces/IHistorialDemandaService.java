package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;

import pe.edu.upc.aaw.smartsupplybackendprod.entities.HistorialDemanda;

import java.util.List;

public interface IHistorialDemandaService {
    public List<HistorialDemanda> list();
    public HistorialDemanda listId(Long id);
    public void insert(HistorialDemanda historial);
}
