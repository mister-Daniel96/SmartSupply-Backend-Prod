package pe.edu.upc.aaw.smartsupplybackendprod.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.ArticuloDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IArticuloService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private IArticuloService aS;

    @GetMapping
    public List<ArticuloDTO> lista() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArticuloDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ArticuloDTO listaId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        ArticuloDTO d = m.map(aS.listid(id), ArticuloDTO.class);
        return d;
    }
}
