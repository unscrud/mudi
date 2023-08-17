package dev.unscrud.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import dev.unscrud.mudi.model.Pedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeDoProduto("Teclado Mecânico Bora");
        pedido.setDataDaEntrega(LocalDate.now());
        pedido.setValorNegociado(new BigDecimal("149,99"));
        pedido.setUrlProdudo("https://www.amazon.com.br/Teclado-Mec%C3%A2nico-T-dagger-Bora-Switch/dp/B0833F1KQ3/ref=sr_1_6?keywords=teclado+mecanico&qid=1692286853&sprefix=TECLA%2Caps%2C407&sr=8-6&ufe=app_do%3Aamzn1.fos.6121c6c4-c969-43ae-92f7-cc248fc6181d");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/61j-3qqbAhL._AC_SX522_.jpg");
        pedido.setDescricao("T-DAGGER Teclado Mecânico Bora Rgb Switch - T-tgk315-bl, PRETO");
        
        model.addAttribute(pedido);
        return "home";
    }
}