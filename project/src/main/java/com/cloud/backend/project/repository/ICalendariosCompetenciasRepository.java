package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CalendariosCompetencias;

public interface ICalendariosCompetenciasRepository {

    public Boolean insertar(CalendariosCompetencias calendariosCompetencias);
    public CalendariosCompetencias buscarPorId(Integer id);
    public Boolean actualizar(CalendariosCompetencias calendariosCompetencias);
    public Boolean eliminar(Integer id);
}
