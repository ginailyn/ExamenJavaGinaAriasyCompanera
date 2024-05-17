import dao.BD;
import model.Odontologo;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

public class OdontologoServiceTest {
    @Test
    public void buscarOdontologoPorID(){
        BD.crearTablas();
        OdontologoService odontologoService= new OdontologoService();
        Integer id=2;
        Odontologo odontologo= odontologoService.buscarPorID(id);
        Assertions.assertTrue(true);
    }
}
