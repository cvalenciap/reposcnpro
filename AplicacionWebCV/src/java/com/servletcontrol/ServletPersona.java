/*
 servlet que actua como controlador de las peticiones
 */
package com.servletcontrol;

import com.modelo.entidades.Persona;
import com.jpa.modelodao.PersonaJpaController;
import com.modelo.ConexionModelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erlan Valencia
 */
public class ServletPersona extends HttpServlet {
    
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            recuperarAccion(request, response);
        } catch (Exception error) {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
//metodo para procesar acciones que llegan d ela vista al servlet

    public void recuperarAccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String accion = request.getParameter("accion");
        if (accion.equals("Guardar") == true) {
            guardarPersona(request, response);
        } else {
            if (accion.equals("sol_agregar")) {
                request.setAttribute("accion", "mos_agregar");
                request.getRequestDispatcher("/web/persona/crud_persona.jsp").forward(request, response);
            } else {
                if (accion.equals("sol_buscar")) {
                    request.setAttribute("accion", "mos_buscar");
                    request.getRequestDispatcher("/web/persona/crud_persona.jsp").forward(request, response);
                } else {
                    if (accion.equals("Buscar")) {
                        buscarPersona(request, response);
                    } else {
                        if (accion.equals("Eliminar")) {
                            eliminarPersona(request, response);
                        } else {
                            if (accion.equals("sol_listar")) {
                                request.setAttribute("accion", "mos_listar");
                                request.getRequestDispatcher("/web/persona/buscar.jsp").forward(request, response);
                            }else{
                                if(accion.equals("inicio")){
                                    response.sendRedirect(request.getContextPath()+"/web/persona/index.jsp");
                                }else{
                                    if(accion.equals("Listar")){
                                        listarPersona(request, response);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //METODO PARA LISTAR LAS PERSONAS del sistema

    public void listarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
     
        try {
            //recuperamos los datos
            String opcion = request.getParameter("opcion");
            String filtro = request.getParameter("filtro");
            //crear una conexion
            ConexionModelo conexion = ConexionModelo.getConexion();
            //crear el dao tipo persona
            PersonaJpaController daoPer = new PersonaJpaController(conexion.getFabricaConexion());
            //invocamos al metodo buscar todas las personas findPersonaEntities
            List<Persona> listot = daoPer.findPersonaEntities();
            List<Persona> listado = new ArrayList<Persona>();
            Iterator<Persona> iterador1 = listot.iterator();
            if(opcion.equals("edad")){
                int contador = 0;
                while(iterador1.hasNext()==true){
                    contador+= 1;
                    Persona per = iterador1.next();
                    if(per.getEdad()== Integer.parseInt(filtro)){
                        listado.add(per);
                    }
                }
            }else{
                if(opcion.equals("apellido")){
                    int contador = 0;
                    while(iterador1.hasNext()==true){
                        contador+= 1;
                        Persona per = iterador1.next();
                        if((per.getApellido()).equals(filtro)==true){
                            listado.add(per);
                        }
                    }
                }
            }                        
            if (listado != null) {
                request.setAttribute("persona.listar", listado);
                request.setAttribute("accion","bus_persona");
                request.getRequestDispatcher("/web/persona/resultadosbus.jsp").forward(request, response);
            } else {
                request.setAttribute("ruta", "/cpersona");
                request.setAttribute("proxima accion", "inicio");
                request.setAttribute("estilo", "info");
                request.setAttribute("mensaje", "El sistema no tiene personas registradas");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception error) {
            request.setAttribute("ruta", "/cpersona");
            request.setAttribute("proxima accion", "inicio");
            request.setAttribute("estilo", "error");
            request.setAttribute("mensaje", "Ocurrio al realizar el listado de las Personas");
            throw error;
        }
    }

    //METODO PARA BUSCAR PERSONAS
    public void buscarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        //recuperar el id
        String id = request.getParameter("idPersonas");
        try {
            //crear una conexion
            ConexionModelo conexion = ConexionModelo.getConexion();
            //crear el dao tipo persona
            PersonaJpaController daoPer = new PersonaJpaController(conexion.getFabricaConexion());
            //se instancia la persona y se le asigna el metodo buscar pasandole el id como parametro
            Persona per = daoPer.findPersona(Integer.parseInt(id));
            //si la persona fue encontrada 
            if (per != null) {
                //se envia la accion mos_persona
                request.setAttribute("accion", "mos_persona");
                //se asigna la instancia per a persona encontrada para mostrarse
                request.setAttribute("persona encontrada", per);
                //se envia el mensaje de encontrado
                request.setAttribute("mensaje", "Persona " + per.getNombre() + " " + per.getApellido() + " encontrado");
                //redireccionamos a la vista crud_persona
                request.getRequestDispatcher("/web/persona/crud_persona.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Persona no existe");
                request.setAttribute("estilo", "info");
                request.setAttribute("ruta", "/cpersona");
                request.setAttribute("proxima accion", "sol_buscar");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }catch (Exception error) {
            request.setAttribute("ruta", "/cpersona");
            request.setAttribute("proxima accion", "inicio");
            request.setAttribute("estilo", "error");
            request.setAttribute("mensaje", "Ocurrio al buscar a la Persona");
            throw error;
        }

    }

    //METODO PAR ELIMINAR PERSONAS

    public void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        //recuperar el id
        String id = request.getParameter("idPersonas");
        //crear una conexion
        try {
            ConexionModelo conexion = ConexionModelo.getConexion();
            //crear el dao de tipo persona
            PersonaJpaController daoPer = new PersonaJpaController(conexion.getFabricaConexion());
            //invocar el metodo eliminar pasandole el id como parametro
            daoPer.destroy(Integer.valueOf(id));
            //si el persona fue eliminado se envia mensaje de ok
            request.setAttribute("mensaje", "La persona " + id + " fue eliminada");
            //se envia la accion mos_buscar
            request.setAttribute("accion", "mos_buscar");
            //colocamos la persona encontrada en nulo para que no lo vuelva a mostrar
            request.setAttribute("persona encontrada", null);
            //redireccionamos a la vista crud_persona.jsp
            request.getRequestDispatcher("/web/persona/crud_persona.jsp").forward(request, response);
        } catch (Exception error) {
            request.setAttribute("ruta", "/cpersona");
            request.setAttribute("proxima accion", "sol_buscar");
            request.setAttribute("estilo", "error");
            request.setAttribute("mensaje", "ocurrio un error al eliminar la persona ID: " + id);
            throw error;

        }
    }

    public void guardarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        //recupera los parametros de la peticion
        String idPersonas = request.getParameter("idPersonas");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");
        //crea la instancia de entidad
        Persona per = new Persona();
        per.setIdPersonas(Integer.parseInt(idPersonas));
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setEdad(Integer.parseInt(edad));
        //establecer la conexion con la BD
        try {
            ConexionModelo conexion = ConexionModelo.getConexion();
            //se crea una instancia de dao
            PersonaJpaController daoPer = new PersonaJpaController(conexion.getFabricaConexion());
            daoPer.create(per);
            request.setAttribute("accion", "mos_agregar");
            request.setAttribute("mensaje", "Persona " + per.getIdPersonas() + " se agrego con exito");
            request.getRequestDispatcher("/web/persona/crud_persona.jsp").forward(request, response);

            //response.sendRedirect("web/persona/agregar.jsp?mensaje=OK, Persona "+per.getNombre()+" "+per.getApellido()+" fue agregada al sistema");
        } catch (Exception error) {
            //response.sendRedirect("web/persona/agregar.jsp?mensaje=Error, Problemas con el servidor");
                request.setAttribute("mensaje", "Problemas con el Servidor de BD");
                request.setAttribute("estilo", "error");
                request.setAttribute("ruta", "/cpersona");
                request.setAttribute("proxima accion", "sol_agregar");
                throw error;           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
