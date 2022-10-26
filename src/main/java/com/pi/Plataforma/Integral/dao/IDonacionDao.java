package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Donacion;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDonacionDao extends JpaRepository<Donacion, Long> {




}
