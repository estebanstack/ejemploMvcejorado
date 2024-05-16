package controladores;

import Vista.UsuarioUI;
import modelos.Usuario;
import repositorios.UsuarioDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController implements ActionListener {
    private UsuarioUI uiUsuario;
    private UsuarioDao usuarioDao;
    private Usuario usuario;
    private DefaultTableModel modeloT;

    public UsuarioController(UsuarioUI uiUsuario, UsuarioDao usuarioDao) {
        this.uiUsuario = uiUsuario; //asociacion
        this.usuarioDao=new UsuarioDao(); //composicion
        this.uiUsuario.crearButton.addActionListener(this);
        this.uiUsuario.consultarButton.addActionListener(this);
        this.modeloT=(DefaultTableModel) uiUsuario.tbConsultarTodos.getModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.uiUsuario.crearButton)){
            usuario=new Usuario();
            usuario.setId(Integer.parseInt(this.uiUsuario.id.getText()));
            usuario.setNombre(this.uiUsuario.nombre.getText());
            if(usuarioDao.crear(usuario)){
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo crear :(");
            }
        }
        if(e.getSource().equals(this.uiUsuario.consultarButton)){
            int id= Integer.parseInt(this.uiUsuario.id.getText());
            usuario=usuarioDao.getUsuario(id);
            if(usuario==null){
                JOptionPane.showMessageDialog(null, "Este usuario no existw");
            }else {
                this.uiUsuario.nombre.setText(usuario.getNombre());
            }
        }
        if(e.getSource().equals(this.uiUsuario.updateButton)){
            usuario.setNombre(this.uiUsuario.nombre.getText());
            
        }
    }
}
