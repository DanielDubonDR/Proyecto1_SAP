
package Principal.Controlador;

/**
 *
 * @author Daniel Dubón
 */
public class Usuario {
    private String usuario, nombre, contrasenia;
    
    public Usuario(String usuario, String nombre, String contrasenia)
    {
        setUsuario(usuario);
        setNombre(nombre);
        setContrasenia(contrasenia);
    }
    
    public void setUsuario(String usuario)
    {
        this.usuario=usuario;
    }
    
    public void setNombre(String usuario)
    {
        this.usuario=usuario;
    }
    
    public void setContrasenia(String usuario)
    {
        this.usuario=usuario;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getContrasenia()
    {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + '}';
    }
    
    
}
