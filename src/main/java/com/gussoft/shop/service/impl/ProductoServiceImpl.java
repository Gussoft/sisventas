package com.gussoft.shop.service.impl;

import com.gussoft.shop.dao.ProductoDAO;
import com.gussoft.shop.dao.impl.ProductoDAOImpl;
import com.gussoft.shop.dto.ProductoDTO;
import com.gussoft.shop.service.ProductoService;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<ProductoDTO> listar() {
        ProductoDAO pdao = new ProductoDAOImpl();
        return pdao.listar();
    }

    @Override
    public ProductoDTO listarId(int id) {
        ProductoDAO pdao = new ProductoDAOImpl();
        return pdao.listarId(id);
    }

}
