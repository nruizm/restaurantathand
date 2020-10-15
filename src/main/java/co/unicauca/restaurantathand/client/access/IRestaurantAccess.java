package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.commons.domain.Restaurant;

/**
 *
 * Interface que define los servicios de persitencia de Restaurantes 
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */

public interface IRestaurantAccess 
{
    /**
     * Buscar un cliente utilizando un socket
     *
     * @param prmNitRest Nit del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public Restaurant findRestaurant(String prmNitRest) throws Exception;
    
    /**
     * Crea un Restaurante
     *
     * @param prmRestaurant restaurante
     * @return devuelve el nit del restaurante creado
     * @throws Exception error crear el restaurante
     */

    public String createRestaurant(Restaurant prmRestaurant) throws Exception;
    
}
