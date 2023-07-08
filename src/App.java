import DAO.UsuarioDao;
import entity.Usuario;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Informe seu usuário: ");
        String user;
        Scanner username = new Scanner(System.in);
        user = username.nextLine();
        System.out.println("Informe sua senha: ");
        String pass;
        Scanner password = new Scanner(System.in);
        pass = password.nextLine();


        Usuario u = new Usuario();
        u.setNomeUsuario(user);
        u.setSenhaUsuario(pass);
        new UsuarioDao().cadastrarUsuario(u);

        UsuarioDao objUsuarioDao = new UsuarioDao();
        for(Usuario x : objUsuarioDao.ListarUsuario()) {
            System.out.println("ID: " + x.getIdUsuario());
            System.out.println("Usuário: " + x.getNomeUsuario());
            System.out.println("Senha: "+ x.getSenhaUsuario());
        }
    }
}
