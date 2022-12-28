package me.ketlas.web;

import me.ketlas.config.ConsulConfiguration;
import me.ketlas.config.VaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class BillingRestController {

    @Autowired
    private ConsulConfiguration consulConfiguration;

    @Autowired
    private VaultConfiguration vaultConfiguration;

    @GetMapping("/myConfig")
    public Map<String,Object> getMyConfig(){
        return Map.of("consult_config",consulConfiguration,"vault_config",vaultConfiguration);
    }
}
