package repositorios;

import modelos.Usuario;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class UsuarioDao {
    ArrayList<Usuario> usuarios;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String filePath="usuarios.dat";

    public UsuarioDao() {
        usuarios=new ArrayList<>();
        File file=new File(filePath);
        if(file.isFile()){
            try{
                this.entrada=new ObjectInputStream(new FileInputStream(filePath));
                this.usuarios = (ArrayList<Usuario>) entrada.readObject();
                this.entrada.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                guardar();
            }
        }
    }

    public boolean crear(Usuario usuario) {
       return usuarios.add(usuario);
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public Usuario getUsuario(int id) {
        for(Usuario usuario:usuarios) {
            if (id == usuario.getId()) {
                return usuario;
            }
        }
            return null;
        }
    public void update(int id, Usuario usuario) {
        for(Usuario usuario1:usuarios) {
            if (id == usuario1.getId()) {
                usuario1.setNombre(usuario.getNombre());
                usuario1.setApellido(usuario.getApellido());
                usuario1.setCorreo(usuario.getCorreo());
                usuario1.setEdad(usuario.getEdad());
            }
        }
        //usuarios.set(id,usuario);
    }
    public boolean eliminar(Usuario usuario) {
        return usuarios.remove(usuario);
    }
    public void guardar() throws IOException {
        this.salida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
        this.salida.writeObject(usuarios);
        salida.close();
        
    }
}
