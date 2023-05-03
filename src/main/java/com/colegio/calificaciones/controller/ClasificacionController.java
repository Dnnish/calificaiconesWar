package com.colegio.calificaciones.controller;


import com.colegio.calificaciones.config.page;
import com.colegio.calificaciones.dto.ClasificacionDto;
import com.colegio.calificaciones.model.Clasificacion;
import com.colegio.calificaciones.service.impl.ClasificacionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/api/v1/Calificacion")
public class ClasificacionController {

    /**
     * @see ClasificacionService
     */
    private ClasificacionService clasificacionService;

    public ClasificacionController(ClasificacionService clasificacionService){
        this.clasificacionService = clasificacionService;
    }
    // intento nº1 de mostrar

    /**
     * @param id
     * @return
     */
    @GetMapping(path = {"/asignaturas", "/asignaturas/{id}"})
    public ModelAndView getAsignaturaIndividual(@RequestParam(defaultValue = "1", name="id", required = false) int id){
        ModelAndView modelAndView = new ModelAndView(page.Home);

        List<ClasificacionDto> Clasificacionfiltrado = this.getClasificacion().stream()
                .filter((a) -> {
                    return a.getId() == id;
                }).collect(Collectors.toList());

        modelAndView.addObject("post",Clasificacionfiltrado.get(0));
        return modelAndView;
    }
    // Muestra todos los alumnos y sus notas

    /**
     * Muestra todos los alumnos que esten en la base de datos
     * @return
     */
    @GetMapping(value = "/id")
    public List<ClasificacionDto> getClasificacion(){
        return clasificacionService.getClasificacion();
    }

    // Que un estudiante pueda obtener todas las calificaciones de sus distintas asignaturas

    /**
     * Recoge de la url los datos y los introduce en el parametro y lo en envia a
     * clasificacionService.getClasificacionesByAlumnoId()
     * @param id
     * @return
     */
    @GetMapping(value = "/alumno")
    public List<ClasificacionDto> getClasificacionesByAlumnoId(@RequestParam Long id){
        return clasificacionService.getClasificacionesByAlumnoId(id);
    }

    //Que un profesor pueda obtener de su asignatura/s las calificaciones por estudiante.

    /**
     * Recoge de la url los datos y los introduce en los parametros establecidos y con ellos los enviamos con el return
     * a clasificacionService al metodo getClasificacionesByProfesorAndAsignatura para que se encargue de los datos
     * y lo use en su lógica
     * @param profesorId
     * @param asignaturaId
     * @return
     */
    @GetMapping(value = "/profesor/asignaturas")
    public List<ClasificacionDto> getClasificacionesByProfesorAndAsignatura(@RequestParam Long profesorId,@RequestParam Long asignaturaId){
        return clasificacionService.getClasificacionesByProfesorAndAsignatura(profesorId, asignaturaId);
    }
    // Para agregar un nueva clasificacion, pero no ha sido establecido
    @PostMapping
    public void registerNewCalificacion(@RequestBody Clasificacion clasificacion){
        clasificacionService.addNewClasificacion(clasificacion);
    }

    public ClasificacionService getClasificacionService() {
        return clasificacionService;
    }

    public void setClasificacionService(ClasificacionService clasificacionService) {
        this.clasificacionService = clasificacionService;
    }

}
