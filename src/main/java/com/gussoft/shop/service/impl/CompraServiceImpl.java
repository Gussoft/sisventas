
package com.gussoft.shop.service.impl;

import com.gussoft.shop.dao.CompraDAO;
import com.gussoft.shop.dao.impl.CompraDAOImpl;
import com.gussoft.shop.dto.CompraDTO;
import com.gussoft.shop.service.CompraService;

public class CompraServiceImpl implements CompraService{

    @Override
    public int GenerarCompra(CompraDTO compra) {
        CompraDAO cdao = new CompraDAOImpl();
        return cdao.GenerarCompra(compra);
    }
    
}
