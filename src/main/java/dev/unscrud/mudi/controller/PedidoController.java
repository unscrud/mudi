package dev.unscrud.mudi.controller;

import dev.unscrud.mudi.dto.NovoPedido;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public ModelAndView novo(@Valid NovoPedido novoPedido, BindingResult result){
        ModelAndView mv;
        
        if (result.hasErrors()){
            mv = new ModelAndView("pedido/formulario");
            return mv;
        }
        
        Pedido pedido = novoPedido.toPedido();
        pedidoRepository.save(pedido);
        
        mv = new ModelAndView("pedido/novo");
        return mv;
    }
}
