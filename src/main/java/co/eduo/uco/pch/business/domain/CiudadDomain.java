package co.eduo.uco.pch.business.domain;

import java.util.UUID;

import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;
import co.eduo.uco.pch.crosscutting.helpers.TextHelpers;
import co.eduo.uco.pch.crosscutting.helpers.UUIDHelper;

public class CiudadDomain {
	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	
	
	private CiudadDomain(final UUID id,final String nombre,final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static final CiudadDomain build(final UUID id,final String nombre,final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}
	
	public static final CiudadDomain build(final UUID id) {
		return new CiudadDomain(id, TextHelpers.EMPTY, DepartamentoDomain.build());
	}
	
	public static final CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefault(), TextHelpers.EMPTY, DepartamentoDomain.build());
	}
	
	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	private final void setNombre(final String nombre) {
		this.nombre = TextHelpers.applyTrim(nombre);
	}
	private final void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, DepartamentoDomain.build());
	}
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}
	
	
	
	

}
