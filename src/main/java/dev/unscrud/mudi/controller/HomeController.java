package dev.unscrud.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public ModelAndView home(Model model) {
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        
        return mv;
    }
    
    @GetMapping("/aguardando")
    public ModelAndView aguardando(Model model) {
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO);
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        
        return mv;
    }
}
