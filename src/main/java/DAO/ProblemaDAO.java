package DAO;

import entidades.Problemas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author abelc
 */
public class ProblemaDAO {

    private EntityManager entityManager;

    public ProblemaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Problemas registrarProblema(Problemas problema) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(problema);
            entityManager.getTransaction().commit();
            return problema;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        }
    }

    public List<Problemas> buscarPorDescripcion(String descripcion) {
        String jpql = "SELECT p FROM Problemas p WHERE p.descripcion LIKE :descripcion";
        TypedQuery<Problemas> typedQuery = entityManager.createQuery(jpql, Problemas.class);
        typedQuery.setParameter("descripcion", "%" + descripcion + "%");
        return typedQuery.getResultList();
    }
}
