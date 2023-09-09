package dev.unscrud.mudi.api;

import dev.unscrud.mudi.interceptor.InterceptadorDeAcessos;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/acessos")
@RestController
public class AcessosRest {
    
    @GetMapping
    public List<InterceptadorDeAcessos.Acesso> getAcessos(){
        return InterceptadorDeAcessos.acessos;
    }
}
