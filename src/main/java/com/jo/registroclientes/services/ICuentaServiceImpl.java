package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Cuenta;
import com.jo.registroclientes.model.entity.LineaDeCuenta;
import com.jo.registroclientes.model.entity.LineaDeCuentaConProducto;
import com.jo.registroclientes.model.entity.LineaDeCuentaSaldo;
import com.jo.registroclientes.repository.ICuentaRepository;
import com.jo.registroclientes.repository.ILineaConProductoRepository;
import com.jo.registroclientes.repository.ILineaConSaldoRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ICuentaServiceImpl implements IServiceGenerico<Cuenta, Long> {

    @Autowired
    private ICuentaRepository cuentaRepository;
    @Autowired
    private ILineaConSaldoRpository lineaConSaldoRpository;
    @Autowired
    private ILineaConProductoRepository lineaConProductoRepository;
    @Override
    public ResponseEntityDTO<List<Cuenta>> getAll() {

        return new ResponseEntityDTO<List<Cuenta>>(cuentaRepository.findAll(),null,null);
    }

    @Override
    public ResponseEntityDTO<Cuenta> get(Long aLong) {
        Optional<Cuenta> cuenta= cuentaRepository.findById(aLong);
        if(!cuenta.isPresent()){
            return  new ResponseEntityDTO<Cuenta>(null, "No se encontro la cuenta numero: ".concat(aLong.toString()), null);
        }
        return new ResponseEntityDTO<Cuenta>(cuenta.get(), null, null);
    }

    @Override
    public ResponseEntityDTO<Cuenta> save(Cuenta entity) {
         Cuenta cuenta= cuentaRepository.save(entity);
        return new ResponseEntityDTO<Cuenta>(cuenta,null,null);
    }

    @Override
    public ResponseEntityDTO<Cuenta> delete(Long aLong) {
        Cuenta cuenta=get(aLong).getData();
        cuentaRepository.delete(cuenta);

        return  new ResponseEntityDTO<Cuenta>(cuenta,null,null);
    }

    @Override
    public ResponseEntityDTO<Cuenta> update(Long aLong, Cuenta entity) {
        Cuenta cuenta=get(aLong).getData();
        cuenta.setEstado_cuenta(entity.getEstado_cuenta());
        cuentaRepository.save(cuenta);
        return new ResponseEntityDTO<Cuenta>(cuenta,null,null);
    }

    public ResponseEntityDTO<LineaDeCuenta> agregarLineaDeCuenta(Long aLong, LineaDeCuentaSaldo linea) {
       ResponseEntityDTO<Cuenta> cuenta= get(aLong);
       if(cuenta.getData()==null){
            return  new ResponseEntityDTO<LineaDeCuenta>(null, cuenta.getError(), cuenta.getMenssage());
       }
       LineaDeCuentaSaldo li = new LineaDeCuentaSaldo(cuenta.getData(),linea.getMonto(),linea.getDescripcion());
       LineaDeCuenta newLine= lineaConSaldoRpository.save(li);
        return new ResponseEntityDTO<LineaDeCuenta>(newLine,null,null);
    }

    public ResponseEntityDTO<LineaDeCuenta> agregarLineaDeCuentaProducto(Long aLong, LineaDeCuentaConProducto linea) {
        ResponseEntityDTO<Cuenta> cuenta= get(aLong);
        if(cuenta.getData()==null){
            return  new ResponseEntityDTO<LineaDeCuenta>(null, cuenta.getError(), cuenta.getMenssage());
        }
        LineaDeCuentaConProducto li = new LineaDeCuentaConProducto(cuenta.getData(),linea.getCantidad(),linea.getProducto());
        LineaDeCuenta newLine= lineaConProductoRepository.save(li);
        return new ResponseEntityDTO<LineaDeCuenta>(newLine,null,null);
    }

    public ResponseEntityDTO<List<Cuenta>> cuentasByClient(Long id){

        return  new ResponseEntityDTO<List<Cuenta>>(cuentaRepository.findCuentasByClient(id),null,null);
    }

}
