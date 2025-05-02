package pe.edu.vallegrande.issue.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IssueKafkaEventDto {
    private Long id;
    private String name;
    private Integer workshopId;
    private String sesion;
    private LocalDateTime scheduledTime;
    private String state;
}
