package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar RestaurantAccess o cualquier
 * otro que se cree en el futuro.
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 * 
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantAccess
     *
     * @return una clase hija de la abstracción IRepositorioRestaurantes
     */
    public IRestaurantAccess getRestaurantService() {

        IRestaurantAccess result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "default":
                result = new RestaurantAccessImplSockets();
                break;
        }

        return result;

    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia IDishAccess
     *
     * @return una clase hija de la abstracción IRepositorioDish
     */
    public IDishAccess getDishService() {

        IDishAccess result = null;
        String type = Utilities.loadProperty("dish.service");

        switch (type) {
            case "default":
                result = new DishAccessImplSockets();
                break;
        }

        return result;

    }
}
