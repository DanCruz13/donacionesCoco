/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Database.Objeto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped

public class ObjetosBean {

    private Objeto obj;
    private List<Objeto> lista;

    public Objeto getObj() {
        return obj;
    }

    public void setObj(Objeto obj) {
        this.obj = obj;
    }

    public List<Objeto> getLista() {
        return lista;
    }

    public void setLista(List<Objeto> lista) {
        this.lista = lista;
    }

    public ObjetosBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer userId = (Integer) context.getExternalContext().getSessionMap().get("id");
        if (userId != null) {
            obj = new Objeto();
            lista = new ArrayList();
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistence");
            EntityManager entitymanager = emfactory.createEntityManager();
            Query query = entitymanager.createNamedQuery("ListaDonaciones.findAll", Objeto.class);

            List<Objeto> aux = query.getResultList();
            for (Objeto x : aux) {

                {
                    if (x.getDonadoA() == null) {
                        System.out.println(x.getNombre());
                        lista.add(x);
                    }

                }

            }

        } else {
            try {
                context.getExternalContext().redirect("/proyecto_donaciones");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void mine(Integer id) {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer userId = (Integer) context.getExternalContext().getSessionMap().get("id");
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Objeto x = entitymanager.find(Objeto.class, id);
        x.setDonadoA(userId);

        Query query = entitymanager.createQuery("Update Objeto o SET o.donadoA = " + userId.toString() + " WHERE o.idobjeto = " + id.toString());
        query.executeUpdate();
        entitymanager.getTransaction().commit();
        try {
            context.getExternalContext().redirect("/proyecto_donaciones/faces/start.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
