package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.AsistenciaDao;
import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.dao.IInstructorDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    private final AsistenciaDao asistenciaDao;

    private final IUssuriooooDao ussuriooooDao;

    private final IInstructorDao instructorDao;

    private final IActividadDao actividadDao;

    public AsistenciaServiceImpl(AsistenciaDao asistenciaDao, IInstructorDao instructorDao, IUssuriooooDao ussuriooooDao, IActividadDao actividadDao)
    {
        this.asistenciaDao=asistenciaDao;
        this.actividadDao=actividadDao;
        this.instructorDao=instructorDao;
        this.ussuriooooDao=ussuriooooDao;
    }
    @Override
    @Transactional
    public Asistencia save(Asistencia asistencia){
        Long id_usuario = asistencia.getUssurioooo().getId();
        asistencia.setUssurioooo(null);

        Long id_actividad = asistencia.getActividad().getId();
        asistencia.setActividad(null);

        Long id_instructor = asistencia.getInstructor().getId();
        asistencia.setInstructor(null);

        Asistencia donanteSave = asistenciaDao.save(asistencia);

        asistenciaDao.updateAllRelations(donanteSave.getId(), id_actividad, id_usuario,id_instructor);

        return  asistenciaDao.getById(asistencia.getId());

    }

    @Override
    public List<Asistencia> getAll() {
        return null;
    }

    @Override
    public Asistencia getById(Long id) {
        return null;
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return null;
    }

    @Override
    public List<Instructor> getInstructor() {
        return null;
    }

    @Override
    public List<Actividad> getActividad() {
        return null;
    }


}
