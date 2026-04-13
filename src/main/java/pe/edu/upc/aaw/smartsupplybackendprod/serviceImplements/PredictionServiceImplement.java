package pe.edu.upc.aaw.smartsupplybackendprod.serviceImplements;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionRequestDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.dtos.PredictionResponseDTO;
import pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces.IPredictionService;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class PredictionServiceImplement implements IPredictionService {

    // Ejemplo en application.properties:
    // ml.api.url=https://smartsupply-prediccion-2.onrender.com/predict_range
    @Value("${ml.api.url}")
    private String mlApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public PredictionResponseDTO obtenerPrediccion(PredictionRequestDTO request) {

        // Validación básica: debe venir name o cod
        if (request.getTipoArticuloName() == null && request.getTipoArticuloCod() == null) {
            throw new IllegalArgumentException("Debes enviar tipo_articulo_name o tipo_articulo_cod");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        // Armamos el JSON EXACTO que espera FastAPI
        Map<String, Object> body = new HashMap<>();
        body.put("tipo_articulo_name", request.getTipoArticuloName());   // opcional
        body.put("tipo_articulo_cod", request.getTipoArticuloCod());     // opcional

        // FastAPI espera string "YYYY-MM-DD" → formateamos el LocalDate
        body.put("fecha_inicio", request.getFechaInicio().format(formatter));
        body.put("fecha_fin", request.getFechaFin().format(formatter));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        //System.out.println("📤 ENVIANDO A FASTAPI → " + body);

        ResponseEntity<PredictionResponseDTO> response = restTemplate.exchange(
                mlApiUrl,                 // debe ser /predict_range
                HttpMethod.POST,
                entity,
                PredictionResponseDTO.class
        );

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Error llamando al servicio de ML: " + response.getStatusCode());
        }

        return response.getBody();
    }
}
