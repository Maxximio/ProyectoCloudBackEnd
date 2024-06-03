package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CalendariosCompetencias;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CalendariosCompetenciasRepositoryImpl implements ICalendariosCompetenciasRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean insertar(CalendariosCompetencias calendariosCompetencias) {
        try {
            this.entityManager.persist(calendariosCompetencias);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public CalendariosCompetencias buscarPorId(Integer id) {
        return this.entityManager.find(CalendariosCompetencias.class, id);
    }

    @Override
    public Boolean actualizar(CalendariosCompetencias calendariosCompetencias) {
        try {
            this.entityManager.merge(calendariosCompetencias);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            this.entityManager.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
