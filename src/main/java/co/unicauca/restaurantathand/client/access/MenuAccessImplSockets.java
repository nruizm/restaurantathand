package co.unicauca.restaurantathand.client.access;

import co.unicauca.restaurantathand.client.infra.RestaurantSocket;
import co.unicauca.restaurantathand.commons.domain.Menu;
import co.unicauca.restaurantathand.commons.infra.JsonError;
import co.unicauca.restaurantathand.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Menu. Permite hacer el CRUD de Platos solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 * 
 * @author Mannuel Fernando Granoble
 *         Michel Andrea Gutierrez Vallejo
 *         Ximena Quijano Gutierrez
 *         Nathalia Ruiz Menses
 */
public class MenuAccessImplSockets implements IMenuAccess{
  /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;
    
    public MenuAccessImplSockets ()
    {
        mySocket = new RestaurantSocket();
    }
    
    /**
     * Busca un Menu. Utiliza socket para pedir el servicio al servidor
     *
     * @param prmIdMenu Id del Menu
     * @return Objeto Menu
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    
    @Override  
     public Menu findMenu(String prmIdMenu) throws Exception {
        String jsonResponse = null;
        String requestJson = findMenuRequestJson(prmIdMenu);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(MenuAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(MenuAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el menu
                Menu menu = jsonToMenu(jsonResponse);
                return menu;
            }
        }
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param prmIdMenu identificación del Menu
     * @return solicitud de consulta del menu en formato Json, algo como:
     * {"resource":menu","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findMenuRequestJson(String prmIdMenu) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("get");
        protocol.addParameter("idmenu", prmIdMenu);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    
    
    @Override
    public String createMenu(Menu prmMenu) throws Exception  
    {
        String jsonResponse = null;
        String requestJson = createMenuRequestJson(prmMenu);
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
                //Agregó correctamente, devuelve el Id de Menu 
                return prmMenu.getAtrIdMenu();
            }

         }
    }
    
    /**
     * Crea la solicitud json de creación del Menu para ser enviado por el
     * socket
     *
     * @param prmMenu objeto Menu
     * @return devulve algo como:
     * {"resource":"menu","action":"post","parameters":[{"name":"idmenu","value":"980000012"},{"name":"namemenu","value":"Carne"},...}]}
     */
    
     private String createMenuRequestJson (Menu prmMenu) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("post");
        protocol.addParameter("idmenu", prmMenu.getAtrIdMenu());
        protocol.addParameter("nameMenu", prmMenu.getAtrNomMenu());
        protocol.addParameter("fechamenu", prmMenu.getAtrFecVimenu() + "");
        protocol.addParameter("typemenu", prmMenu.getAtrTypeMenu());
        
        
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
     * Convierte jsonMenu, proveniente del server socket, de json a un
     * objeto Menu
     *
     * @param jsonMenu objeto Menu en formato json
     */
    private Menu jsonToMenu(String jsonMenu) {

        Gson gson = new Gson();
        Menu varMenu = gson.fromJson(jsonMenu, Menu.class);

        return varMenu;

    }

   
}
