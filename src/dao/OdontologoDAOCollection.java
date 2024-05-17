package dao;

import service.OdontologoService;
import model.Odontologo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.util.Map;

import org.apache.log4j.Logger;

public class OdontologoDAOCollection implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOCollection.class);

    private Map<Integer, Odontologo> odontologos = new HashMap<>();
    private int currentId = 1;

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        odontologo.setId(currentId++);
        odontologos.put(odontologo.getId(), odontologo);
        logger.info("Odontólogo guardado en colección: " + odontologo.getNombre() + " " + odontologo.getApellido());

        return odontologo;

    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Lista de todos los odontólogos obtenida de la colección.");
        return new ArrayList<>(odontologos.values());

    }
}
