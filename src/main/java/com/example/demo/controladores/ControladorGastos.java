package com.example.demo.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.modelos.Gasto;
import com.example.demo.servicios.ServicioGastos;

@Controller
public class ControladorGastos 
{
	private final ServicioGastos servicioGastos;

	public ControladorGastos(ServicioGastos servicioGastos) 
	{
		
		this.servicioGastos = servicioGastos;
	}
	
	@RequestMapping(value="/expenses", method=RequestMethod.GET)
	public String register (@ModelAttribute("gasto") Gasto gasto, Model model)
	{
		
		List<Gasto> gastos = servicioGastos.get_all();
		
		model.addAttribute("gastos",gastos);
		
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("gasto") Gasto gasto,
						 BindingResult result)
	{
		
		if(result.hasErrors())
		{
			return "index.jsp";
		}
		else
		{
			servicioGastos.save_expense(gasto);
			return "redirect:/expenses";
		}
	
	}
	
}
