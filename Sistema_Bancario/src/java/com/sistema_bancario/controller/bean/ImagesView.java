/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


/**
 *
 * @author EQUIPO
 */
@Named(value = "imagesView")
@Dependent
public class ImagesView {

    
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("noticia" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
    

