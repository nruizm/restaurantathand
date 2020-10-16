/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.commons.domain.Menu;



/**
 *Interface que define los servicios de persistencia del Menu
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public interface IMenuAccess {
     /**
     * Buscar un Menu utilizando un socket
     *
     * @param prmIdMenu Id del menu
     * @return objeto Menu
     * @throws Exception error al buscar un Menu
     */
    public Menu findMenu(String prmIdMenu) throws Exception;
    
    /**
     * Crea un Menu
     *
     * @param prmMenu Menu
     * @return devuelve el Id del Menu creado
     * @throws Exception error crear el Menu
     */

    public String createMenu(Menu prmMenu) throws Exception;
    
}
