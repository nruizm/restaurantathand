/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.domain.services;

import co.unicauca.restaurantathand.client.access.IDishAccess;
import co.unicauca.restaurantathand.commons.domain.Dish;

/**
 *
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class DishService {
    private final IDishAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IDishAccess
     */
    public DishService(IDishAccess service) 
    {
        this.service = service;
    }

    /**
     * Busca un Plato en el servidor remoto
     *
     * @param prmIdDish identificador del Platos
     * @return Objeto tipo Plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Dish findDish(String prmIdDish) throws Exception 
    {
        return service.findDish(prmIdDish);

    }
    
    public String createDish(Dish prmDish) throws Exception
    {
        return service.createDish(prmDish);

    }    
}
