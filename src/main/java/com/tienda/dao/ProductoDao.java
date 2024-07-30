package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    @Query("SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(nativeQuery = true, value = "SELECT * FROM Producto WHERE precio BETWEEN :precioInf AND :precioSup ORDER BY descripcion ASC")
    List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

}
