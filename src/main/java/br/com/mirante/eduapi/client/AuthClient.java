package br.com.mirante.eduapi.client;

import br.com.mirante.eduapi.dto.UserDTO;
import br.com.mirante.eduapi.feignclient.AutenticacaoConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth", url = "${api.auth}", configuration = {AutenticacaoConfig.class})
public interface AuthClient {

    @RequestMapping(method = RequestMethod.POST, value = "admin/realms/mirante/users")
    ResponseEntity<Void> cadastrarUsuario(@RequestBody UserDTO userDTO);
}
