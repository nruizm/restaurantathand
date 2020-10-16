package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.commons.domain.Person;

/**
 * Interface que define los servicios de persistencia de Usuarios de la app
 *
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public interface IPersonAccess {

    /**
     * Buscar un Usuario utlizando un socket
     *
     * @param id Id del restaurante
     * @return Objeto restaurant
     * @throws Exception
     */
    public Person findUser(String id) throws Exception;

    /**
     * Crea un Usario
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String createUser(Person user) throws Exception;
}
