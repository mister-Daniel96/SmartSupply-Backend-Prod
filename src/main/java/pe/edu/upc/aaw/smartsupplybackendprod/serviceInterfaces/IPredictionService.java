package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;


import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionRequestDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionResponseDTO;

public interface IPredictionService {
    PredictionResponseDTO obtenerPrediccion(PredictionRequestDTO request);
}
