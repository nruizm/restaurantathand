/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.domain.services;

import co.unicauca.restaurantathand.client.access.IRestaurantAccess;
import co.unicauca.restaurantathand.commons.domain.Restaurant;

/**
 *
 * @author lenovo
 */
public class RestaurantService
{
    private final IRestaurantAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo ICustomerService
     */
    public RestaurantService(IRestaurantAccess service) 
    {
        this.service = service;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param prmNit identificador del cliente
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Restaurant findRestaurant(String prmNit) throws Exception 
    {
        return service.findRestaurant(prmNit);

    }
    
    public String createRestaurant(Restaurant prmRestaurant) throws Exception
    {
        return service.createRestaurant(prmRestaurant);

    }    
}
