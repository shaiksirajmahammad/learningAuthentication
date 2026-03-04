package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponseDto {
    Long id;
    String name;
}
