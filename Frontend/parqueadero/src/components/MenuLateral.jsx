import { Link } from "react-router-dom"
import { alertaRedireccion } from "../helpers/funciones"
import { useNavigate } from "react-router-dom"
const MenuLateral = () => {
  let redireccion = useNavigate()
  function cerrarSesion() {
    alertaRedireccion("Cerrando sesión", "/", redireccion)
  }

  return (
    <aside className="aplicacion__menu-lateral">
      <h1 className="aplicacion__menu-lateral-logo">Parqueadero<span className="aplicacion__menu-lateral-logo--resaltado">X</span></h1>
      <h2>Usuario: {localStorage.getItem("usuario")}</h2>
      <img className="aplicacion__menu-lateral-logo-imagen" src="Logo.jpg" alt="Logo" />
      <nav className="aplicacion__menu-lateral-navegacion">
        <Link className="aplicacion__menu-lateral-navegacion-item" to="">Inicio</Link>
        <Link className="aplicacion__menu-lateral-navegacion-item" to="Reservas Espacio">Reservas Espacio</Link>
        <Link className="aplicacion__menu-lateral-navegacion-item" to="Cuenta">Cuenta</Link>
        <Link className="aplicacion__menu-lateral-navegacion-item" to="Pagos">Pagos</Link>
        <Link className="aplicacion__menu-lateral-navegacion-item" to="Contactenos">Contactenos</Link>
        <button onClick={cerrarSesion} type='button' className="aplicacion__menu-lateral-navegacion-item">Cerrar sesión</button>
      </nav>
    </aside>
  )
}

export default MenuLateral