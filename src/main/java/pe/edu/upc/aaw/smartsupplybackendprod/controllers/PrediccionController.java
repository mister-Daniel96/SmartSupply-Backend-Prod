package pe.edu.upc.aaw.smartsupplybackendprod.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionRequestDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionResponseDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceImplements.PredictionServiceImplement;

@RestController
@RequestMapping("/predicciones")
public class PrediccionController {

    private final PredictionServiceImplement prediccionService;

    public PrediccionController(PredictionServiceImplement prediccionService) {
        this.prediccionService = prediccionService;
    }

    @PostMapping
    public PredictionResponseDTO predecir(@RequestBody PredictionRequestDTO request) {

        //System.out.println("📥 REQUEST EN JAVA → " + request.getTipoArticuloName()
       //         + " / " + request.getFechaInicio()
         //       + " / " + request.getFechaFin());

        return prediccionService.obtenerPrediccion(request);
    }


}
