package co.unicauca.restaurantathand.client.domain.services;

import co.unicauca.restaurantathand.client.access.IPersonAccess;
import co.unicauca.restaurantathand.commons.domain.Person;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class PersonService {

    private final IPersonAccess service;
      /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IUserAccess
     */
    public PersonService(IPersonAccess service) {
        this.service = service;
    }
     /**
     * Busca un Usuario en el servidor remoto
     *
     * @param id identificador del Usuario
     * @return Objeto tipo User, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Person findUser(String id) throws Exception {
        return service.findUser(id);
    }
        /**
     * Crear un obeto Usuario en el servidor remoto
     * @param user el objeto a crear
     * @return un string con el id del objeto creado
     * @throws Exception 
     */
    public String createUser(Person user) throws Exception {
        return service.createUser(user);
    }
}
