package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;

import pe.edu.upc.aaw.smartsupplybackendprod.entities.Categoria;

import java.util.List;

public interface ICategoriaService {
    public void insert(Categoria categoria);
    public List<Categoria> list();
    public void delete(Long idCategoria);
    public Categoria listid(Long idCategoria);}
