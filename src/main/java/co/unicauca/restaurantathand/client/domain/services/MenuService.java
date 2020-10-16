/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.domain.services;

import co.unicauca.restaurantathand.client.access.IMenuAccess;
import co.unicauca.restaurantathand.commons.domain.Menu;

/**
 *
 * @author lenovo
 */
public class MenuService {
     private final IMenuAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IMenuAccess
     */
    public MenuService(IMenuAccess service) 
    {
        this.service = service;
    }

    /**
     * Busca un Menu en el servidor remoto
     *
     * @param prmIdMenu identificador del Menu
     * @return Objeto tipo Menu, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Menu findDish(String prmIdMenu) throws Exception 
    {
        return service.findMenu(prmIdMenu);

    }
    
    public String createDish(Menu prmMenu) throws Exception
    {
        return service.createMenu(prmMenu);

    }  
}
