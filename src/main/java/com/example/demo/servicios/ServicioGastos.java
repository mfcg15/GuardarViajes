package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.Gasto;
import com.example.demo.repositorios.RepositorioGastos;

@Service
public class ServicioGastos 
{
	private final RepositorioGastos repositorioGastos;

	public ServicioGastos(RepositorioGastos repositorioGastos) 
	{
		this.repositorioGastos = repositorioGastos;
	}
	
	public Gasto save_expense(Gasto expense)
	{
		return repositorioGastos.save(expense);
	}
	
	public List<Gasto> get_all()
	{
		return repositorioGastos.findAll();
	}
	
}
