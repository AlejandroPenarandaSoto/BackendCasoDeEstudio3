package casoestudio.producto_Concreto;



import casoestudio.objetos.Configuracion;
import casoestudio.producto_abstracto._Usuario;

import java.sql.*;
import java.util.ArrayList;
import static java.lang.System.out;

public class _UsuarioDAO {

    public ArrayList<_Usuarios> listarUsuarios() {

        ArrayList<_Usuarios> usuarios = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM fge_usuarios";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {


                String nombre = rs.getString("NOMBRE");
                String apellido1 = rs.getString("APELLIDO1");
                String apellido2 = rs.getString("APELLIDO2");
                String telefono = rs.getString("TELEFONO");
                int rol_id = rs.getInt("id_rol");
                _Usuarios u = new _Usuarios(nombre,apellido1,apellido2,telefono,rol_id);
                usuarios.add(u);

            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        }
        return usuarios;
    }

}