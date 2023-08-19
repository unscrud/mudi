package dev.unscrud.mudi.controller;

import dev.unscrud.mudi.dto.NovoPedido;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("formulario")
    public ModelAndView formulario(){
        ModelAndView mv = new ModelAndView("pedido/formulario");
        return mv;
    }
    
    @PostMapping("novo")
    public ModelAndView novo(NovoPedido novoPedido){
        Pedido pedido = novoPedido.toPedido();
        pedidoRepository.save(pedido);
        
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
}
