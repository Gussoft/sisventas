package com.gussoft.shop.servlet;

import com.gussoft.shop.config.Fecha;
import com.gussoft.shop.dao.ProductoDAO;
import com.gussoft.shop.dao.impl.ProductoDAOImpl;
import com.gussoft.shop.dto.CarritoDTO;
import com.gussoft.shop.dto.ClienteDTO;
import com.gussoft.shop.dto.CompraDTO;
import com.gussoft.shop.dto.PagoDTO;
import com.gussoft.shop.dto.ProductoDTO;
import com.gussoft.shop.service.CompraService;
import com.gussoft.shop.service.impl.CompraServiceImpl;
import com.gussoft.shop.service.impl.ProductoServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    List<CarritoDTO> listaCarrito = new ArrayList<>();
    int item;
    int cantidad = 1;
    double totalPagar = 0.0;
    int idp;
    CarritoDTO car;

    //ProductoDAO pdao = new ProductoDAOImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoServiceImpl pservice = new ProductoServiceImpl();
        List<ProductoDTO> pro = pservice.listar();//new ArrayList<>();
        ProductoDTO p = new ProductoDTO();

        String accion = request.getParameter("accion");
        //pro= pdao.listar();
        switch (accion) {
            case "Comprar":
                idp = Integer.parseInt(request.getParameter("id"));
                p = pservice.listarId(idp);
                item = item + 1;
                car = new CarritoDTO();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombres());
                car.setFoto(p.getFoto());
                car.setDesc(p.getDesc());
                car.setPrecioc(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad * p.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalpagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("con", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp == listaCarrito.get(i).getIdProducto()) {
                            pos = i;
                        }
                    }
                    if (idp == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioc() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(subtotal);
                    } else {
                        p = pservice.listarId(idp);
                        item = item + 1;
                        car = new CarritoDTO();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombres());
                        car.setFoto(p.getFoto());
                        car.setDesc(p.getDesc());
                        car.setPrecioc(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(cantidad * p.getPrecio());
                        listaCarrito.add(car);
                    }
                } else {
                    p = pservice.listarId(idp);
                    item = item + 1;
                    car = new CarritoDTO();
                    car.setItem(item);
                    car.setIdProducto(p.getId());
                    car.setNombres(p.getNombres());
                    car.setFoto(p.getFoto());
                    car.setDesc(p.getDesc());
                    car.setPrecioc(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubtotal(cantidad * p.getPrecio());
                    listaCarrito.add(car);
                }

                request.setAttribute("con", listaCarrito.size());
                request.getRequestDispatcher("ProductoServlet?accion=home").forward(request, response);
                break;
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idproducto) {
                        listaCarrito.remove(i);
                    }
                }

                break;
            case "ActualizarCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPrecioc() * cant;
                        listaCarrito.get(i).setSubtotal(st);
                    }
                }
                break;
            case "Carrito":
                totalPagar = 0.0;
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                }
                request.setAttribute("totalpagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "Nuevo":
                listaCarrito = new ArrayList();
                request.getRequestDispatcher("ProductoServlet?accion=home").forward(request, response);
                break;
            case "GenerarCompra":
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(1);
                CompraService cdao = new CompraServiceImpl();
                PagoDTO pago = new PagoDTO();
                pago.setId(1);
                CompraDTO compra = new CompraDTO(cliente, pago.getId(), Fecha.FechaDB(), totalPagar, "Cancelado", listaCarrito);
                int res = cdao.GenerarCompra(compra);
                if (res != 0 && totalPagar > 0) {
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                   
                    listaCarrito.clear();
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            default:
                request.setAttribute("con", listaCarrito.size());
                request.setAttribute("productos", pro);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
