package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.commons.domain.Dish;

/**
 * Interface que define los servicios de Plato
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public interface IDishAccess {
    
    /**
     * Buscar un Plato utilizando un socket
     *
     * @param prmIdDish Id del plato
     * @return objeto Plato
     * @throws Exception error al buscar un Plato
     */
    public Dish findDish(String prmIdDish) throws Exception;
    
    /**
     * Crea un Dish
     *
     * @param prmDish Plato
     * @return devuelve el Id del Plato creado
     * @throws Exception error crear el Plato
     */

    public String createDish(Dish prmDish) throws Exception;
    
}
