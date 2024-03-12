/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author abelc
 */
public class ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cliente agregarCliente(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            return cliente;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        }
    }

    public List<Cliente> buscarApellidoPorLetra(String letra) {
    String jpql = "SELECT c FROM Cliente c WHERE c.apPaterno LIKE :letraInicio OR c.apPaterno LIKE :letraFin "
            + "OR c.apMaterno LIKE :letraInicio OR c.apMaterno LIKE :letraFin";
    TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
    query.setParameter("letraInicio", letra + "%"); 
    query.setParameter("letraFin", "%" + letra);   
    return query.getResultList();
}
}
