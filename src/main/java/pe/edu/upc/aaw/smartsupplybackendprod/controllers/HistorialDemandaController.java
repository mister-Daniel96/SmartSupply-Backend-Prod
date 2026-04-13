package pe.edu.upc.aaw.smartsupplybackendprod.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.HistorialDemandaDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.HistorialDemanda;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IHistorialDemandaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historiales")
public class HistorialDemandaController {
    @Autowired
    private IHistorialDemandaService hS;
    @GetMapping
    public List<HistorialDemandaDTO> lista(){
        return hS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, HistorialDemandaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody HistorialDemandaDTO dto){
        ModelMapper m=new ModelMapper();
        HistorialDemanda d=m.map(dto,HistorialDemanda.class);
        hS.insert(d);
    }
}
