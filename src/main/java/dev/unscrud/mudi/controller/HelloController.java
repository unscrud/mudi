package dev.unscrud.mudi.controller;

import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/hello")
    public String hello(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeDoProduto("Teclado Mecânico Bora");
        pedido.setUrlProduto("https://www.amazon.com.br/Teclado-Mec%C3%A2nico-T-dagger-Bora-Switch/dp/B0833F1KQ3/ref=sr_1_6?keywords=teclado+mecanico&qid=1692286853&sprefix=TECLA%2Caps%2C407&sr=8-6&ufe=app_do%3Aamzn1.fos.6121c6c4-c969-43ae-92f7-cc248fc6181d");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/61j-3qqbAhL._AC_SX522_.jpg");
        pedido.setDescricao("T-DAGGER Teclado Mecânico Bora Rgb Switch - T-tgk315-bl, PRETO");
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);

        Pedido pedido2 = new Pedido();
        pedido2.setNomeDoProduto("Celular Samsung S22");
        pedido2.setUrlProduto("https://shop.samsung.com/br/galaxy-s22-ultra-5g/p");
        pedido2.setUrlImagem("https://samsungbrshop.vtexassets.com/arquivos/ids/200596-1200-auto?v=638048057328700000&width=1200&height=auto&aspect=true");
        pedido2.setDescricao("Smartphone Samsung Galaxy S22 Ultra 5G, 256GB, 12GB RAM, Tela Infinita de 6.8\" Preto");
        pedido2.setStatusPedido(StatusPedido.APROVADO);

        Pedido pedido3 = new Pedido();
        pedido3.setNomeDoProduto("Smart Tv 43 Britania Btv43e3aagssgblf Led Full Hd");
        pedido3.setUrlProduto("https://www.mercadolivre.com.br/smart-tv-43-britania-btv43e3aagssgblf-led-full-hd-1920-x-1080-43-dolby-audio-chromecast-built-in-com-netflix-globoplay-youtube-prime-video-110v220v/p/MLB23388396?pdp_filters=deal:MLB779362-1#searchVariation=MLB23388396&position=1&search_layout=grid&type=product&tracking_id=21941007-3db3-4f08-bf8a-9a87e5db833c&c_id=/home/promotions-recommendations/element&c_element_order=1&c_uid=78a954b3-cf90-42a9-b9c6-0475abcadef6");
        pedido3.setUrlImagem("https://http2.mlstatic.com/D_NQ_NP_875331-MLU69516383663_052023-O.webp");
        pedido3.setDescricao("Fast Smart TV Britânia BTV43E3AAGSSGBLF 43” Full HD Led Dolby Audio 110V / 220V");
        pedido3.setStatusPedido(StatusPedido.ENTREGUE);
        pedido3.setDataDaEntrega(LocalDate.now());
        pedido3.setValorNegociado(BigDecimal.valueOf(2000));
        
        pedidoRepository.save(pedido);
        pedidoRepository.save(pedido2);
        pedidoRepository.save(pedido3);
        
        model.addAttribute("nome", "unscrud");
        return "hello";
    }
}
