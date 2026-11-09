package com.prueba.spring.app1.springboot_aplicacion.controllers;

import com.prueba.spring.app1.springboot_aplicacion.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MvcController {

    @Value("${spring.application.name:Actividad 2 - PJXA}")
    private String nombreApp;

    @GetMapping("/productos")
    public String listarProductos(@RequestParam(required = false) String categoria, Model model) {
        List<ProductoDTO> lista = new ArrayList<>();
        ProductoDTO p1 = new ProductoDTO();
        p1.setNombre("Laptop");
        p1.setPrecio(12000.0);
        p1.setCategoria("Tecnologia");
        ProductoDTO p2 = new ProductoDTO();
        p2.setNombre("Teclado");
        p2.setPrecio(450.0);
        p2.setCategoria("Tecnologia");
        ProductoDTO p3 = new ProductoDTO();
        p3.setNombre("Cafetera");
        p3.setPrecio(800.0);
        p3.setCategoria("Hogar");
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        if (categoria != null && !categoria.isEmpty()) {
            lista = lista.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());
        }

        model.addAttribute("productos", lista);
        model.addAttribute("appName", nombreApp);
        return "productos";
    }

    @GetMapping("/productos/{nombre}")
    public String detalleProducto(@PathVariable String nombre, Model model) {
        model.addAttribute("nombreProducto", nombre);
        return "detalle";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        return "formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO, Model model) {
        model.addAttribute("producto", productoDTO);
        return "exito";
    }

    @PostMapping("/api/productos")
    @ResponseBody
    public ProductoDTO crearProductoRest(@RequestBody ProductoDTO productoDTO) {
        return productoDTO;
    }
}