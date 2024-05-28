package co.eduo.uco.pch.data.dao.entity;

import java.util.UUID;

import co.eduo.uco.pch.entity.CiudadEntity;

public interface CiudadDAO  extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity>, UpdateDAO<CiudadEntity>, DeleteDAO<UUID>{

}
