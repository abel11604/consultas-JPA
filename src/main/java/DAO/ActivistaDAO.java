/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.Activista;
import entidades.Cliente;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author abelc
 */
public class ActivistaDAO {

    private EntityManager entityManager;

    public ActivistaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Activista agregarActivista(Activista activista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(activista);
            entityManager.getTransaction().commit();
            return activista;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        }
    }

    public List<Activista> buscarPorPeriodo(Calendar fechaInicio, Calendar fechaFin) {
        String jpql = "SELECT a FROM Activista a WHERE a.fechaInicioLabor BETWEEN :fechaInicio AND :fechaFin";
        TypedQuery<Activista> query = entityManager.createQuery(jpql, Activista.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList();
    }
}
