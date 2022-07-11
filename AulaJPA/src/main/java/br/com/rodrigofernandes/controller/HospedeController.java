package br.com.rodrigofernandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigofernandes.model.Hospede;
import br.com.rodrigofernandes.service.HospedeService;

@Controller
@RequestMapping("/hospede")
public class HospedeController {

	@Autowired
	private HospedeService hService;
	
	@RequestMapping("listar")
	public String home(Model model) {
		List<Hospede> listaHospedes = hService.todos();
		model.addAttribute("listaHospede", listaHospedes);
		return "hospede";
	}
	
	@RequestMapping("adicionar")
	public ModelAndView add(Hospede hospede) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrarhospede");
		mv.addObject("hospede",hospede);
		
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(Hospede hospede) {
		hService.salvar(hospede);
		return "redirect:/hospede/listar";
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		hService.excluirHospede(id);
		
		ModelAndView mv = new ModelAndView("redirect:/hospede/listar");
		
		return mv;
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return add(hService.buscarHospede(id));
	}
		
}
