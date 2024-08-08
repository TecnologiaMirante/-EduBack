package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String email;
    private List<CredentialDTO> credentials;
}
