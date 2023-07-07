package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;

import java.util.List;

public interface IServiceGenerico <T,ID>{
    ResponseEntityDTO<List<T>> getAll ();
    ResponseEntityDTO<T> get(ID id);
    ResponseEntityDTO<T> save(T entity);
    ResponseEntityDTO<T> delete (ID id);
    ResponseEntityDTO<T> update (ID id, T entity);
}
