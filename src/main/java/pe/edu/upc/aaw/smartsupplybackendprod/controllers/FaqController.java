package pe.edu.upc.aaw.smartsupplybackendprod.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.FaqDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IFaqService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faqs")
public class FaqController {
    @Autowired
    private IFaqService fS;

    @GetMapping
    public List<FaqDTO> lista(){
        return fS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, FaqDTO.class);
        }).collect(Collectors.toList());
    }
    // consulta usando el @RequestParam es muy interesante pero por ahora solo consultamos lo que es preguntas generales
}
