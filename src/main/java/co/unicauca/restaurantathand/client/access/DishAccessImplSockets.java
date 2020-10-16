package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.client.infra.RestaurantSocket;
import co.unicauca.restaurantathand.commons.domain.Dish;
import co.unicauca.restaurantathand.commons.infra.JsonError;
import co.unicauca.restaurantathand.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Platos. Permite hacer el CRUD de Platos solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class DishAccessImplSockets implements IDishAccess{

     /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;
    
    public DishAccessImplSockets ()
    {
        mySocket = new RestaurantSocket();
    }
    
    /**
     * Busca un Plato. Utiliza socket para pedir el servicio al servidor
     *
     * @param prmIdDish Id del plato
     * @return Objeto Plato
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    
    @Override  
    public Dish findDish(String prmIdDish) throws Exception {
        String jsonResponse = null;
        String requestJson = findDishRequestJson(prmIdDish);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el Plato
                Dish mainDish = jsonToDish(jsonResponse);
                return mainDish;
            }
        }
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param prmIdDish identificación del plato
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":dish","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findDishRequestJson(String prmIdDish) {

        Protocol protocol = new Protocol();
        protocol.setResource("maindish");
        protocol.setAction("get");
        protocol.addParameter("id_dish", prmIdDish);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    @Override
    public String createDish(Dish prmDish) throws Exception  
    {
        String jsonResponse = null;
        String requestJson = createDishRequestJson(prmDish);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return prmDish.getAtrIdDish();
            }

         }
    }
    
    /**
     * Crea la solicitud json de creación del Plato para ser enviado por el
     * socket
     *
     * @param prmDish objeto Plato
     * @return devulve algo como:
     * {"resource":"dish","action":"post","parameters":[{"name":"iddish","value":"980000012"},{"name":"namedish","value":"Carne"},...}]}
     */
    
     private String createDishRequestJson (Dish prmDish) {

        Protocol protocol = new Protocol();
        protocol.setResource("dish");
        protocol.setAction("post");
        protocol.addParameter("iddish", prmDish.getAtrIdDish());
        protocol.addParameter("namedish", prmDish.getAtrNameDish());
        protocol.addParameter("descriptiondish", prmDish.getAtrDescriptionDish());
        protocol.addParameter("pricedish", prmDish.getAtrPriceDish()+"");
        protocol.addParameter("typedish", prmDish.getAtrTypeDish());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }
    /**
     * Extra los mensajes de la lista de errores
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
     * Convierte jsonDish, proveniente del server socket, de json a un
     * objeto Dish
     *
     * @param jsonDish objeto Plato en formato json
     */
    private Dish jsonToDish(String jsonDish) {

        Gson gson = new Gson();
        Dish restaurant = gson.fromJson(jsonDish, Dish.class);

        return restaurant;

    }
}
