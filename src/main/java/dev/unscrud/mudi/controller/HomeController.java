package dev.unscrud.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public ModelAndView home(Model model, Principal principal) {
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository
                .findAllByUser(principal.getName());
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        
        return mv;
    }
    
    @GetMapping("/{status}")
    public ModelAndView listarPedidosPor(@PathVariable("status") String status, 
            Model model, Principal principal) {
        StatusPedido statusPedido = StatusPedido
                .valueOf(status.toUpperCase());
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository
                .findByStatusPedido(statusPedido, principal.getName());
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        mv.addObject("status", status);
        return mv;
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
