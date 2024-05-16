import Vista.UsuarioUI;
import controladores.UsuarioController;
import repositorios.UsuarioDao;

public class TransmiApp {
    public static void main(String[] args) {
        UsuarioController cUsuario=new UsuarioController(new UsuarioUI(), new UsuarioDao());
    }
}
