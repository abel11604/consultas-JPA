/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.consultasjpa;

import DAO.ActivistaDAO;
import DAO.ClienteDAO;
import DAO.ProblemaDAO;
import entidades.Activista;
import entidades.Cliente;
import entidades.Problemas;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author abelc
 */
public class ConsultasJpa {

    public static void main(String[] args) {
//Crear problema Contaminacion
        EntityManagerFactory mf = Persistence.createEntityManagerFactory("com.mycompany_ConsultasJpa_jar_1.0-SNAPSHOTPU");
        EntityManager em = mf.createEntityManager();
        ProblemaDAO pdao = new ProblemaDAO(em);
        ClienteDAO cdao = new ClienteDAO(em);
        ActivistaDAO adao = new ActivistaDAO(em);
        /*
       //crear Problemas
       Cliente c1 = new Cliente();
        c1.setNombre("Kanye");
        c1.setApPaterno("West");
        c1.setApMaterno("Manzana");
        Problemas problemaPrueba = new Problemas(new GregorianCalendar(2020, 1, 15), "Contaminacion", "Pendiente", c1);
        pdao.registrarProblema(problemaPrueba);*/
 /* Cliente c2 = new Cliente();
        c2.setNombre("Cristiano");
        c2.setApPaterno("Ronaldo");
        c2.setApMaterno("Sanchez");
        Problemas problema2 = new Problemas(new GregorianCalendar(2024, 1, 15),new GregorianCalendar(2024, 1, 22) ,"Aguas residuales", "Solucionado", c2);
        pdao.registrarProblema(problema2);*/
 /*
        List<Problemas> problemas=pdao.buscarPorDescripcion("Contaminacion");
        for (Problemas p:problemas) {
            System.out.println(p.toString());
        }*/

 /*00
       //lista de clientes
       List<Cliente> cliente=cdao.buscarApellidoPorLetra("A");
        for (Cliente c:cliente) {
            System.out.println(c.toString());
        }*/
        //Crear activistas con fechas de 2024 para la consulta
       /* Activista activista = new Activista("Ramona", "Alvarez", "Madero", "643778899", new GregorianCalendar(2024, 2, 15));
        adao.agregarProducto(activista);*/
       
        Calendar Fechainicio = new GregorianCalendar(2024, 1, 1);
        Calendar Fechafinael = new GregorianCalendar(2024, 3, 31);
        List<Activista> activistas=adao.buscarPorPeriodo(Fechainicio, Fechafinael);
         
        for (Activista a:activistas) {
            System.out.println(a.toString());
        }
    }
}
