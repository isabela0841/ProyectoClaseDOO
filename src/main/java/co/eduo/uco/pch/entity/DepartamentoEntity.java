package co.eduo.uco.pch.entity;

import java.util.UUID;

import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;
import co.eduo.uco.pch.crosscutting.helpers.TextHelpers;
import co.eduo.uco.pch.crosscutting.helpers.UUIDHelper;

public class DepartamentoEntity {
	private UUID id;
	private String nombre;
	private PaisEntity pais;
	
	public DepartamentoEntity() {
		super();
	}
	
	public DepartamentoEntity(final UUID id,final String nombre,final PaisEntity pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}
	
	public static final DepartamentoEntity build() {
		return new DepartamentoEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final DepartamentoEntity setId(final UUID id) {
		this.id = UUIDHelper.generate();
		return this;
	}
	public final String getNombre() {
		return nombre = TextHelpers.applyTrim(nombre);
	}
	public final DepartamentoEntity setNombre(final String nombre) {
		this.nombre = TextHelpers.applyTrim(nombre);
		return this;
	}
	public final PaisEntity getPais() {
		return pais;
	}
	public final DepartamentoEntity setPais(final PaisEntity pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisEntity());
		return this;
	}
	
	
	

}