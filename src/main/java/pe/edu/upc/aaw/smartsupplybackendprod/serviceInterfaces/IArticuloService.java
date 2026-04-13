package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;


import pe.edu.upc.aaw.smartsupplybackendprod.entities.Articulo;

import java.util.List;

public interface IArticuloService {
    public void insert(Articulo articulo);
    public List<Articulo> list();
    public void delete(Long idArticulo);
    public Articulo listid(Long idArticulo);}
