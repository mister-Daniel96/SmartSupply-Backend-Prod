package pe.edu.upc.aaw.smartsupplybackendprod.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.ConsultaPrediccionDemanda;
import pe.edu.upc.aaw.smartsupplybackendprod.repositories.IConsultaPrediccionDemandaRepository;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IConsultaPrediccionDemandaService;

import java.util.List;

@Service
public class ConsultaPrediccionDemandaServiceImplement implements IConsultaPrediccionDemandaService {
    @Autowired
    private IConsultaPrediccionDemandaRepository cR;

    @Override
    public List<ConsultaPrediccionDemanda> list() {
        return cR.findAll();
    }

    @Override
    public ConsultaPrediccionDemanda listId(Long id) {
        return cR.findById(id).orElse(new ConsultaPrediccionDemanda());
    }

    @Override
    public void insert(ConsultaPrediccionDemanda consulta) {
        cR.save(consulta);
    }
}
