
package com.gussoft.shop.dao;

import com.gussoft.shop.dto.ProductoDTO;
import java.util.List;

public interface ProductoDAO {
    
    public List listar();
    
    public ProductoDTO listarId(int id);
    
}
