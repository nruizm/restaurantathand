/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.client.infra.RestaurantSocket;
import co.unicauca.restaurantathand.commons.domain.Restaurant;
import co.unicauca.restaurantathand.commons.infra.JsonError;
import co.unicauca.restaurantathand.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * Servicio de Restaurante. Permite hacer el CRUD de restaurante solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class RestaurantAccessImplSockets implements IRestaurantAccess{

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     * 
     */
    
    
    private RestaurantSocket mySocket;
    
    public RestaurantAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }
    
    @Override
    public Restaurant findRestaurant(String prmNitRest) throws Exception {
        String jsonResponse = null;
        String requestJson = findRestaurantRequestJson(prmNitRest);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Restaurant restaurant = jsonToCustomer(jsonResponse);
                return restaurant;
            }
        }

    }

        
    private String createRestaurantRequestJson(Restaurant prmRestaurant) {

        Protocol protocol = new Protocol();
        protocol.setResource("restaurant");
        protocol.setAction("post");
        protocol.addParameter("Nit: ", prmRestaurant.getAtrNitRest());
        protocol.addParameter("Nombre: ", prmRestaurant.getAtrNameRest());
        protocol.addParameter("Direccion: ", prmRestaurant.getAtrAddressRest());
        protocol.addParameter("Telefono: ", prmRestaurant.getAtrMobileRest());
        protocol.addParameter("Email: ", prmRestaurant.getAtrEmailRest());
        //protocol.addParameter("Id Administrador", prmRestaurant.getAtrAdminRest().getAtrIdentificationAdm());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    private String findRestaurantRequestJson(String prmNitRest) {
        
        Protocol protocol = new Protocol();
        protocol.setResource("restaurant");
        protocol.setAction("get");
        protocol.addParameter("nit:", prmNitRest);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

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
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
    
    private Restaurant jsonToCustomer(String jsonCustomer) {

        Gson gson = new Gson();
        Restaurant restaurant = gson.fromJson(jsonCustomer, Restaurant.class);

        return restaurant;

    }

    @Override
    public String createRestaurant(Restaurant prmRestaurant) throws Exception {
       
        String jsonResponse = null;
        String requestJson = createRestaurantRequestJson(prmRestaurant);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return prmRestaurant.getAtrNitRest();
            }

        }
    
    }
    
}
