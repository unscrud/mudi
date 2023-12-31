package dev.unscrud.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public ModelAndView home(Model model, Principal principal) {
        Sort sort = Sort.by("dataDaEntrega").descending();
        PageRequest paginacao = PageRequest.of(0, 3, sort);
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE, paginacao);
        
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        
        return mv;
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
