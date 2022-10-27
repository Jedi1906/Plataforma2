package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.*;

import javax.transaction.Transactional;
import java.util.List;

public interface IIntructorService {

    Instructor save(Instructor instructor);
    Instructor update(Instructor instructor);
    public void delete(Long id);
    List<Instructor> getAll();



}
