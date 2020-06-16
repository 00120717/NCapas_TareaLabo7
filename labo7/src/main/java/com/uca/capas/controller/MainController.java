package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.services.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService	estudianteService;
		
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/save")
    public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
        ModelAndView mav  = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("index");
            System.out.println("if");
        }
        else{
        	estudianteService.save(estudiante);
            Estudiante student = new Estudiante();
            mav.addObject("estudiante", student);
            mav.addObject("exito",1);
            mav.setViewName("index");
            System.out.println("else");
        }
       
        return mav;
    }
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes= null;
		
		try {
			estudiantes = estudianteService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView borrarEstudiante(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes= null;

		try {
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/filtrar")
	public ModelAndView filtrarEstudiante(@RequestParam(value="nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes= null;

		try {
			estudiantes = estudianteService.filtrarPorCadena(cadena);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("listado");
		return mav;
	}

	@RequestMapping("/editar")
	public ModelAndView editar(@RequestParam(value="codigoE") Integer codigo) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		
		try {
			 estudiante = estudianteService.findOne(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		mav.addObject("estudiante",estudiante);
		mav.setViewName("editar");
		return mav;
	}
	
	@RequestMapping("/update")
    public ModelAndView formUpdateEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
        ModelAndView mav  = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("editar");
            System.out.println("if");
        }
        else{
        	estudianteService.save(estudiante,estudiante.getIdEstudiante());
            Estudiante student = new Estudiante();
            mav.addObject("estudiante", student);
            mav.addObject("exito",1);
            mav.setViewName("index");
            System.out.println("else");
        }
       
        return mav;
    }
}
