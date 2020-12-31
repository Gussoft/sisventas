
package com.gussoft.shop.service;

import com.gussoft.shop.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    
    public List<ProductoDTO> listar();
    
    public ProductoDTO listarId(int id);
}
