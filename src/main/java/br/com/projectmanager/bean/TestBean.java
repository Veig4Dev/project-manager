package br.com.projectmanager.bean;


import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TestBean {

    public void testAction() {
        System.out.println("Botão clicado!");
    }
}
