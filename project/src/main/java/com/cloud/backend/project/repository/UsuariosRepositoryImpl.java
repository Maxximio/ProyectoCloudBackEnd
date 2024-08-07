package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.dto.UsuarioDTO;
import com.cloud.backend.project.service.dto.UsuarioDocumentoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuariosRepositoryImpl implements IUsuariosRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuarios insertar(Usuarios usuarios) {
            this.entityManager.persist(usuarios);
            return usuarios;
    }

    @Override
    public Usuarios buscarPorId(Integer id) {
        return this.entityManager.find(Usuarios.class, id);
    }

    @Override
    public Boolean actualizar(Usuarios usuarios) {
        try {
            this.entityManager.merge(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            Usuarios user = this.entityManager.find(Usuarios.class, id);
            this.entityManager.remove(user);
            return true;
        } catch (Exception e) {
            //System.out.println("Error, ->"+e);
            return false;
        }
    }

    @Override
	public List<Usuarios> buscarTodosUsuarios() {
        try {
            TypedQuery<Usuarios> myQuery = this.entityManager.createQuery("SELECT u FROM Usuarios u ",
                    Usuarios.class);
            return myQuery.getResultList();           
        } catch (Exception e) {
            return null;
        }

	}

    @Override
    public Usuarios buscarPorEmail(String email) {
        Usuarios usua = null;
        try {
            TypedQuery<Usuarios> myQuery = this.entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.email=:email",
                    Usuarios.class);
                    usua = myQuery.setParameter("email", email).getSingleResult();   
            return  usua;      
        } catch (NoResultException e) {
            
            return null;
           
        }  
    }

    @Override
    public boolean existeUsuarioConEmail(String email) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);
        try {
            Long count = query.getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public List<Usuarios> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro) {
        TypedQuery<Usuarios> myQ = this.entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.ciudad=:provincia AND u.estadoRegistro=:estadoRegistro",Usuarios.class);
        try {
            myQ.setParameter("estadoRegistro", estadoRegistro).setParameter("provincia", provincia);
            return myQ.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }


    @Override
    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia) {

        try {
            String sql = "SELECT new UsuarioDocumentoDTO(u.id, u.nombres, u.apellidos, u.ciudad, u.email, u.telefono, u.fechaNacimiento, u.sexo, u.estado, u.fechaSuscripción, d) " +
                    "FROM DocumentosUsuarios d JOIN d.usuarios u WHERE d.tipo = :tipoDoc AND u.ciudad = :ciudad";

            if ("Socio".equals(tipoDoc)) {
                sql += " AND u.estado = :estado";
            }
            if ("Registro".equals(tipoDoc)) {
                sql += " AND u.estadoRegistro = :estado";
            }
            if ("Inscripcion".equals(tipoDoc)) {
                sql += " AND u.estadoRegistro = :estado";
            }
            TypedQuery<UsuarioDocumentoDTO> myQ = this.entityManager.createQuery(sql
                    , UsuarioDocumentoDTO.class);

            if ("Socio".equals(tipoDoc) || "Registro".equals(tipoDoc)) {
                myQ.setParameter("estado", estado);
            }
            myQ.setParameter("tipoDoc", tipoDoc);
            myQ.setParameter("ciudad", provincia);
            return myQ.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @Override
    public List<Usuarios> buscarTodosUsuariosAdmin() {
        TypedQuery<Usuarios> myQ = this.entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.roles.id = :roleId", Usuarios.class);
        myQ.setParameter("roleId", 1);//id de roles 1
        try {
           return myQ.getResultList();
        } catch (Exception e) {
           e.printStackTrace();
           return new ArrayList<>();
        }
    }

}
