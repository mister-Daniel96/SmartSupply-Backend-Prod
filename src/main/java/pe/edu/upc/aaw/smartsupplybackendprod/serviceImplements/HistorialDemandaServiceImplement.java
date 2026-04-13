package pe.edu.upc.aaw.smartsupplybackendprod.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.HistorialDemanda;
import pe.edu.upc.aaw.smartsupplybackendprod.repositories.IHistorialDemandaRepository;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IHistorialDemandaService;

import java.util.List;

@Service
public class HistorialDemandaServiceImplement implements IHistorialDemandaService {
    @Autowired
    private IHistorialDemandaRepository hR;

    @Override
    public List<HistorialDemanda> list() {
        return hR.findAll();
    }

    @Override
    public HistorialDemanda listId(Long id) {
        return hR.findById(id).orElse(new HistorialDemanda());
    }

    @Override
    public void insert(HistorialDemanda historial) {
        hR.save(historial);
    }
}
