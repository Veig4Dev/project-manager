package br.com.projectmanager.bean;


import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String navigate(String page) {
        return page + "?faces-redirect=true";
    }
}
