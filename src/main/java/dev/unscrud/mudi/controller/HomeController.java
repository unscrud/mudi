package dev.unscrud.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import dev.unscrud.mudi.model.Pedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeDoProduto("Teclado Mecânico Bora");
        pedido.setDataDaEntrega(LocalDate.now());
        pedido.setValorNegociado(new BigDecimal("149.99"));
        pedido.setUrlProduto("https://www.amazon.com.br/Teclado-Mec%C3%A2nico-T-dagger-Bora-Switch/dp/B0833F1KQ3/ref=sr_1_6?keywords=teclado+mecanico&qid=1692286853&sprefix=TECLA%2Caps%2C407&sr=8-6&ufe=app_do%3Aamzn1.fos.6121c6c4-c969-43ae-92f7-cc248fc6181d");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/61j-3qqbAhL._AC_SX522_.jpg");
        pedido.setDescricao("T-DAGGER Teclado Mecânico Bora Rgb Switch - T-tgk315-bl, PRETO");
        
        Pedido pedido2 = new Pedido();
        pedido2.setNomeDoProduto("Teclado Mecânico Bora");
        pedido2.setDataDaEntrega(LocalDate.now());
        pedido2.setValorNegociado(new BigDecimal("149.99"));
        pedido2.setUrlProduto("https://www.amazon.com.br/Teclado-Mec%C3%A2nico-T-dagger-Bora-Switch/dp/B0833F1KQ3/ref=sr_1_6?keywords=teclado+mecanico&qid=1692286853&sprefix=TECLA%2Caps%2C407&sr=8-6&ufe=app_do%3Aamzn1.fos.6121c6c4-c969-43ae-92f7-cc248fc6181d");
        pedido2.setUrlImagem("https://m.media-amazon.com/images/I/61j-3qqbAhL._AC_SX522_.jpg");
        pedido2.setDescricao("T-DAGGER Teclado Mecânico Bora Rgb Switch - T-tgk315-bl, PRETO");
    
        Pedido pedido3 = new Pedido();
        pedido3.setNomeDoProduto("Teclado Mecânico Bora");
        pedido3.setDataDaEntrega(LocalDate.now());
        pedido3.setValorNegociado(new BigDecimal("149.99"));
        pedido3.setUrlProduto("https://www.amazon.com.br/Teclado-Mec%C3%A2nico-T-dagger-Bora-Switch/dp/B0833F1KQ3/ref=sr_1_6?keywords=teclado+mecanico&qid=1692286853&sprefix=TECLA%2Caps%2C407&sr=8-6&ufe=app_do%3Aamzn1.fos.6121c6c4-c969-43ae-92f7-cc248fc6181d");
        pedido3.setUrlImagem("https://m.media-amazon.com/images/I/61j-3qqbAhL._AC_SX522_.jpg");
        pedido3.setDescricao("T-DAGGER Teclado Mecânico Bora Rgb Switch - T-tgk315-bl, PRETO");
        
        List<Pedido> pedidos = Arrays.asList(pedido, pedido2, pedido3);
        
        model.addAttribute(pedidos);
        
        return "home";
    }
}
