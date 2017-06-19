/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Database.Usuarios;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@Named(value = "LoginBean")
@SessionScoped
public class LoginBean {

    public LoginBean() {
    }

    private String usuario;
    private String contra;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createNamedQuery("Usuarios.findByUsuario", Usuarios.class);
        query.setParameter("pass", this.contra);
        query.setParameter("usuario", this.usuario);
        List<Usuarios> results = query.getResultList();
        for (Usuarios x : results) {
        }
        if (results.size() < 1) {
            usuario = null;
            contra = null;
            try {
                context.getExternalContext().redirect("/proyecto_donaciones?error=log");
                System.out.println("no se pudo");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "/forms?error=log";
        } else {

            context.getExternalContext().getSessionMap().put("user", usuario);
            Database.Usuarios user = (Database.Usuarios) results.get(0);
            context.getExternalContext().getSessionMap().put("id", user.getIdusuarios());
            try {
                context.getExternalContext().redirect("/proyecto_donaciones/faces/Inicio.xhtml");
                System.out.println("si se pudo wuujuuu");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("user");
        context.getExternalContext().getSessionMap().remove("id");
        try {
            context.getExternalContext().redirect("/proyecto_donaciones");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/proyecto_donaciones";
    }

}
