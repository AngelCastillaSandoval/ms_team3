package pe.edu.vallegrande.issue.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.issue.dto.IssueKafkaEventDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC = "issue-events";

    /**
     * 🔹 Envía un evento relacionado a una incidencia al topic "issue-events".
     */
    public void sendIssueEvent(IssueKafkaEventDto eventDto) {
        try {
            String message = objectMapper.writeValueAsString(eventDto);
            kafkaTemplate.send(TOPIC, String.valueOf(eventDto.getId()), message);
            log.info("📤 Evento enviado a Kafka -> Topic: {}, Key: {}, Payload: {}", TOPIC, eventDto.getId(), message);
        } catch (Exception e) {
            log.error("❌ Error al enviar evento a Kafka: {}", e.getMessage(), e);
        }
    }
}
