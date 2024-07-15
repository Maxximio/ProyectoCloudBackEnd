package com.cloud.backend.project.repository;

import java.util.ArrayList;
import java.util.List;

import com.cloud.backend.project.service.dto.CompetidoresEstadoDTO;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Competidores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompetidoresRepository implements ICompetidoresRepository{
    
    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Boolean insertar(Competidores competidores) {
        try {
            this.entityManager.persist(competidores);
            System.out.println("Insertado");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            System.out.println("Meko");
            return false;
        }
    }

    @Override
    public Boolean actualizar(Competidores competidores) {
        try {
            this.entityManager.merge(competidores);
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            this.entityManager.remove(buscarPorId(id));
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Competidores buscarPorId(Integer id) {
        return this.entityManager.find(Competidores.class, id);    
    }

	@Override
	public List<Competidores> listarCompetidores() {
        TypedQuery<Competidores> myQuery = this.entityManager.createQuery("SELECT c FROM Competidores c",Competidores.class);
        return myQuery.getResultList();
	}


    @Override
    public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(Boolean estado, String estadoParticipacion, String ciudad) {
        try {
            String sql = "SELECT new CompetidoresEstadoDTO(c.id, c.fechaInscripcion, c.estadoParticipacion, u.id, u.nombres, u.apellidos, u.ciudad, u.email, u.telefono, u.fechaNacimiento, u.sexo, d) " +
                    "FROM Competidores c " +
                    "JOIN c.usuarios u " +
                    "LEFT JOIN DocumentosUsuarios d ON d.usuarios.id = u.id " +
                    "WHERE d.tipo = :tipoDoc AND c.estadoParticipacion = :estadoParticipacion AND u.ciudad = :ciudad";

            TypedQuery<CompetidoresEstadoDTO> query = entityManager.createQuery(sql, CompetidoresEstadoDTO.class);
            query.setParameter("estadoParticipacion", estadoParticipacion);
            query.setParameter("ciudad", ciudad);
            query.setParameter("tipoDoc", "Inscripcion");
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
