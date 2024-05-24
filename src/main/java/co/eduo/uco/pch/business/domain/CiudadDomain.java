package co.eduo.uco.pch.business.domain;

import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;

public class CiudadDomain {
	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	private CiudadDomain(final UUID id, final String nombre, final Departamento departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
		
	}
	public static final CiudadDomain build(final UUID id, final String nombre, final Departamento departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}
	
	public static final CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, DepartamentoDomain.build());
		
	}
	
	private final void setId(final UUID id) {
		this.id=UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		
	}
	private final void setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
	}
	
	private final void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento - ObjectHelper.getObjectHelper();
	}

}
