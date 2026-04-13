package pe.edu.upc.aaw.smartsupplybackendprod.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.Categoria;
import pe.edu.upc.aaw.smartsupplybackendprod.repositories.ICategoriaRepository;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImplement implements ICategoriaService {
    @Autowired
    private ICategoriaRepository dR;

    @Override
    public void insert(Categoria categoria) {
        dR.save(categoria);
    }

    @Override
    public List<Categoria> list() {
        return dR.findAll();
    }

    @Override
    public void delete(Long idCategoria) {
        dR.deleteById(idCategoria);
    }

    @Override
    public Categoria listid(Long idCategoria) {
        return dR.findById(idCategoria).orElse(new Categoria());
    }
}
