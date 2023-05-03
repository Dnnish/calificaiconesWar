package com.colegio.calificaciones.service.impl;

import com.colegio.calificaciones.dto.ClasificacionDto;
import com.colegio.calificaciones.model.Alumno;
import com.colegio.calificaciones.model.Asignatura;
import com.colegio.calificaciones.model.Clasificacion;
import com.colegio.calificaciones.repository.Alumnorepository;
import com.colegio.calificaciones.repository.AsignaturaRepository;
import com.colegio.calificaciones.repository.Clasificacionrepository;
import com.colegio.calificaciones.repository.ProfesorRepository;
import com.colegio.calificaciones.service.IClasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClasificacionService implements IClasificacion {



    public ClasificacionService() {
    }

    public ClasificacionService(AsignaturaRepository asignaturaRepository, ProfesorRepository profesorRepository, Alumnorepository alumnorepository, Clasificacionrepository clasificacionrepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.profesorRepository = profesorRepository;
        this.alumnorepository = alumnorepository;
        this.clasificacionrepository = clasificacionrepository;
    }

    @Autowired
    private Clasificacionrepository clasificacionrepository;

    @Autowired
    private Alumnorepository alumnorepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    /**
     * Devuelve una lista de objetos ClasificacionDto que contienen las calificaciones de todos los alumnos en todas las asignaturas.
     * @return una lista de objetos {@link ClasificacionDto} que contiene las calificaciones encontradas y la información del alumno y la asignatura, o una lista vacía si no se encuentran calificaciones
     */
    @Override
    public List<ClasificacionDto> getClasificacion() {
        // request data
        List<Clasificacion> clasificacionList = clasificacionrepository.findAll();
        List<ClasificacionDto> clasificacionDtoList = new ArrayList<>();

        for (Clasificacion value : clasificacionList) {
            long asignaturaId = value.getAsignaturaId();
            long alumnoId = value.getAlumnoId();

            Alumno alumno = alumnorepository.findById(alumnoId).orElse(null);
            Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);

            // data mapping
            ClasificacionDto clasificacionDto = toClasificacionDto(value, alumno, asignatura);
            if (clasificacionDto != null) {
                clasificacionDtoList.add(clasificacionDto);
            }
        }
        return clasificacionDtoList;
    }

    // Que un estudiante pueda obtener todas las calificaciones de sus distintas asignaturas

    /**
     * Devuelve una lista de objetos ClasificacionDto que contienen todas las calificaciones de un alumno en distintas asignaturas.
     * @param AlumnoId el ID del alumno cuyas calificaciones se buscan
     * @return una lista de objetos {@link ClasificacionDto} que contiene las calificaciones encontradas y
     * la información del alumno y la asignatura, o una lista vacía si no se encuentran calificaciones
     */
    @Override
    public List<ClasificacionDto> getClasificacionesByAlumnoId(Long AlumnoId) {
        // request data
        // Busca al alumno con la id que nos han proporcionado y guardamos al alumno en una varible
        Alumno alumno = alumnorepository.findById(AlumnoId).orElse(null);
        // Coger al alumno y ponerlo en una lista para poder desglosar su informacion
        List<Clasificacion> clasificacionList = clasificacionrepository.findByAlumnoId(AlumnoId);
        //  Crear una lista para para poner todos los nombres de las asignaturas
        List<ClasificacionDto> clasificacionDtoList = new ArrayList<>();
        //  Aqui hacemos un foreach para coger la asignatura y pasarsela al Dto
        for (Clasificacion value : clasificacionList) {
            long asignaturaId = value.getAsignaturaId();
            Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);

            // data mapping
            ClasificacionDto clasificacionDto = toClasificacionDto(value, alumno, asignatura);
            if (clasificacionDto !=null) {
                clasificacionDtoList.add(clasificacionDto);
            }
        }
        //devolver el resultado
        return clasificacionDtoList;
    }

    //Que un profesor pueda obtener de su asignatura/s las calificaciones por estudiante.
    /**
     * Devuelve una lista de objetos ClasificacionDto que contienen las calificaciones de un profesor en una asignatura determinada.
     * @param profesorId el ID del profesor que busca las calificaciones
     * @param asignaturaId el ID de la asignatura cuyas calificaciones se buscan
     * @return una lista de objetos {@link ClasificacionDto} que contiene las calificaciones encontradas y la información del alumno y la asignatura, o una lista vacía si no se encuentran calificaciones
     */
    @Override
    public List<ClasificacionDto> getClasificacionesByProfesorAndAsignatura(Long profesorId, Long asignaturaId) {
        // request data
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);
        List<Clasificacion> clasificacionList = clasificacionrepository.findByClasificacionByProfesorAndAsignatura(profesorId, asignaturaId);
        List<ClasificacionDto> clasificacionDtoList = new ArrayList<>();

        for (Clasificacion value : clasificacionList) {
            // data mapping
            Alumno alumno = alumnorepository.findById(value.getAlumnoId()).orElse(null);
            ClasificacionDto profesorDto = toClasificacionDto(value, alumno, asignatura);
            if (profesorDto !=null) {
                clasificacionDtoList.add(profesorDto);
            }
        }
        return clasificacionDtoList;
    }

    /**
     * Convierte una Clasificacion, un Alumno y una Asignatura en un objeto ClasificacionDto, mapeando la información que no se obtiene mediante los métodos.
     * getClasificacionesByAlumnoId/getClasificacion/getClasificacionesByProfesorAndAsignatura. Si alguna de las entradas es nula, el
     * método devuelve un valor nulo. De lo contrario, crea un objeto ClasificacionDto utilizando los parámetros de entrada y los devuelve.
     * @param clasificacion la clasificación que se va a convertir en ClasificacionDto
     * @param alumno el alumno asociado a la clasificación
     * @param asignatura la asignatura asociada a la clasificación
     * @return un objeto ClasificacionDto que contiene la información de la clasificación, el alumno y la asignatura, o nulo si alguna de las entradas es nula
     */
    private ClasificacionDto toClasificacionDto(Clasificacion clasificacion, Alumno alumno, Asignatura asignatura) {

        if (clasificacion == null || alumno == null || asignatura == null) {
            return null;
        }
        ClasificacionDto clasificacionDto = new ClasificacionDto();
        clasificacionDto.setId(alumno.getAlu_codalu());
        clasificacionDto.setAsigid(asignatura.getAsi_codasi());
        clasificacionDto.setNota(clasificacion.getNota());
        clasificacionDto.setAlumnoName(alumno.getName());
        clasificacionDto.setAsignaturaName(asignatura.getName());
        return clasificacionDto;
    }

    @Override
    public void addNewClasificacion(Clasificacion clasificacion) {

        clasificacionrepository.save(clasificacion);
    }
}
    // Anterior antes de Quinxiu me lo corrigiera
    /*@Override
    public List<ClasificacionDto>getClasificacionesByProfesorAndAsignatura(Long profesorID, Long asignaturaId) {
        // request data
        Profesor profesorId = profesorRepository.findById(profesorID).orElse(null);
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);
        List<Clasificacion> clasificacionList = clasificacionrepository.findByAsignaturaIdAndProfesorId(asignaturaId, profesorID);
        List<ClasificacionDto> clasificacionDtoList = new ArrayList<>();
        for (Clasificacion value : clasificacionList) {
        // data mapping
            Alumno alumno = alumnorepository.findById(value.getAlumnoId()).orElse(null);
            ClasificacionDto profesorDto = toProfesorDto(value, alumno, asignatura, profesorId);
            if (profesorDto !=null && profesorId.getPro_codpro() == profesorID) {
                clasificacionDtoList.add(profesorDto);
            }
        }
        return clasificacionDtoList;
    }
*/
