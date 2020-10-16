package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.client.infra.PersonSocket;
import co.unicauca.restaurantathand.commons.domain.Person;
import co.unicauca.restaurantathand.commons.infra.JsonError;
import co.unicauca.restaurantathand.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * servicio de Usuario. Permite hacer el CRUD de Usuaruis solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class PersonAccessImplSockets implements IPersonAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private PersonSocket mySocket;

    PersonAccessImplSockets() {
        mySocket = new PersonSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param id id del usuario
     * @return Objeto User
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Person findUser(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findUserRequestJson(id);

        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(PersonAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }

        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor este escuchando");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvio algun error
                Logger.getLogger(PersonAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontro un usuario
                Person user = jsonToUser(jsonResponse);
                return user;
            }
        }

    }

    /**
     * Crea un ususario. Utiliza socket para pedir el servicio al servidor
     *
     * @param user ususario de la agencia de viajes
     * @return devuelve el id del ususario creado
     * @throws Exception error crear el ususario
     */
    @Override
    public String createUser(Person user) throws Exception {
        String jsonResponse = null;
        String requestJson = createUserRequestJson(user);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(PersonAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(PersonAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el userName del usuarioS 
                return user.getAtrUserName() + "";
            }

        }
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param userName id del usuario
     * @return solicitud de consulta del ususario en formato Json, algo como:
     * {"resource":"user","action":"get","parameters":[{"name":"userName","value":"98000001"}]}
     */
    private String findUserRequestJson(String userName) {
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("get");
        protocol.addParameter("usernameper", userName);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Convierte jsonRestaurant, proveniente del server socket, de json a un
     * objeto User
     *
     * @param jsonUser objeto cliente en formato json
     */
    private Person jsonToUser(String jsonUser) {

        Gson gson = new Gson();
        Person user = gson.fromJson(jsonUser, Person.class);

        return user;

    }

    /**
     * Crea la solicitud json de creación del Usuario para ser enviado por el
     * socket
     *
     * @param user objeto customer
     * @return devulve algo como:
     * {"resource":"Usuario","action":"post","parameters":[{"name":"UserName","value":"980000012"},{"name":"UserContraseña","value":"Juan"},...}]}
     */
    private String createUserRequestJson(Person user) {

        Protocol protocol = new Protocol();
        protocol.setResource("person");
        protocol.setAction("post");
        protocol.addParameter("usernameper", user.getAtrUserName());
        protocol.addParameter("idper", user.getAtrIdentification());
        protocol.addParameter("nameper", user.getAtrName());
        protocol.addParameter("lastnameper", user.getAtrLastName());
        protocol.addParameter("passwordper", user.getAtrPassword());
        protocol.addParameter("cityper", user.getAtrCity());
        protocol.addParameter("addressper", user.getAtrAddress());
        protocol.addParameter("phoneper", user.getAtrPhone());
        protocol.addParameter("typeper", user.getAtrType());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }
}
