package com.colegio.calificaciones.controller;

import com.colegio.calificaciones.config.page;
import com.colegio.calificaciones.dto.ClasificacionDto;
import com.colegio.calificaciones.service.impl.ClasificacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/vista")
public class ThymeleafController {

    private ClasificacionService clasificacionService;

    public ThymeleafController(ClasificacionService clasificacionService){
        this.clasificacionService = clasificacionService;
    }

    public List<ClasificacionDto> getClasificacion(){
        return clasificacionService.getClasificacion();
    }

    List<ClasificacionDto> getClasificacionesByAlumnoId(Long AlumnoId){
        return clasificacionService.getClasificacionesByAlumnoId(AlumnoId);
    }

    List<ClasificacionDto> getClasificacionesByProfesorAndAsignatura(Long profesorId, Long asignaturaId){
        return clasificacionService.getClasificacionesByProfesorAndAsignatura(profesorId,asignaturaId);
    }


    @GetMapping("/asignaturas")
    public String hola(Model model) {

        model.addAttribute("posts", this.getClasificacion());
        return "index";
    }
    @GetMapping({"/posts","/"})
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(page.Home);
        modelAndView.addObject("posts", this.getClasificacion());
        return modelAndView;
    }

    //solucion 1
    @GetMapping(path = "/alumno")
    public ModelAndView getAlumnoIndividual(@RequestParam(defaultValue = "1", name="id", required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("Alumno");

        List<ClasificacionDto> ClasificacionfiltradoList = this.getClasificacionesByAlumnoId(id);

        modelAndView.addObject("ClasificacionList", ClasificacionfiltradoList);
        return modelAndView;
    }

    @GetMapping(path = "/profesor")
    public ModelAndView getProfesorAsig(@RequestParam Long profesorId, Long asignaturaId){
        ModelAndView modelAndView = new ModelAndView("Profesor");

        List<ClasificacionDto> AsignaturasFiltradoList = this.getClasificacionesByProfesorAndAsignatura(profesorId, asignaturaId);
        modelAndView.addObject("AsignaturaList", AsignaturasFiltradoList);
        return modelAndView;
    }
    // Solucion 2
   /*@GetMapping(path = "/alumno")
   public ModelAndView getAlumnoIndividual(@RequestParam(defaultValue = "1", name="id", required = false) Long id){
       ModelAndView modelAndView = new ModelAndView("Alumno");

       List<ClasificacionDto> clasificaciones = this.getClasificacionesByAlumnoId(id);

       Map<Long, List<ClasificacionDto>> clasificacionesPorAsignatura = clasificaciones.stream()
               .collect(Collectors.groupingBy(ClasificacionDto::getAsigid));

       modelAndView.addObject("Alum", clasificacionesPorAsignatura);
       return modelAndView;
   }*/


}