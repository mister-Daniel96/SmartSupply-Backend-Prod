package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;


import pe.edu.upc.aaw.smartsupplybackendprod.entities.ConsultaPrediccionDemanda;

import java.util.List;

public interface IConsultaPrediccionDemandaService {
    public List<ConsultaPrediccionDemanda> list();
    public ConsultaPrediccionDemanda listId(Long id);
    public void insert(ConsultaPrediccionDemanda consulta);

}
