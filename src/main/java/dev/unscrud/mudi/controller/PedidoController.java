package dev.unscrud.mudi.controller;

import dev.unscrud.mudi.dto.NovoPedido;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.User;
import dev.unscrud.mudi.repository.PedidoRepository;
import dev.unscrud.mudi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;    
   
    @GetMapping("formulario")
    public ModelAndView formulario(NovoPedido novoPedido){
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
        
        String username = SecurityContextHolder
                .getContext().getAuthentication().getName();
        
        Pedido pedido = novoPedido.toPedido();
        
        User user = userRepository.findByUsername(username);
        
        pedido.setUser(user);
        pedidoRepository.save(pedido);
        
        mv = new ModelAndView("redirect:/home");
        return mv;
    }
}
