import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import './Login.css'
import { alertaError, alertaRedireccion, generaToken, } from '../helpers/funciones'
// Aca deberia ir la del backend
let apiUsuarios = "http://localhost:8080/api/auth/login"
function Login() {
  const [getNombre, setNombre] = useState("");
  const [getPassword, setPassword] = useState("");
  const [getApellido, setApellido] = useState("");
  const [getEmail, setEmail] = useState("");
  const [usuarios, setUsuarios] = useState([]);
  let redireccion = useNavigate()

  function getUsuarios() {
    fetch(apiUsuarios)
    .then((response) => response.json())
    .then((data) => setUsuarios(data));
  }
  
  useEffect(() => {
    getUsuarios();
  }, []);

  function iniciarSesion() {
    let usuario = usuarios.find(
      (item) => item.usuario == getNombre && item.password == getPassword
    );
    if (usuario) {
      let token = generaToken();
      localStorage.setItem("token", token);
      localStorage.setItem("usuario", usuario.nombre);
      alertaRedireccion("Bienvenido " + usuario.nombre, "/home", redireccion);
    } else {
      alertaError("Error", "Usuario o contraseña incorrectos", "error");
    }
  }

  function registrarUsuario() {
    let usuario = usuarios.find(
      (item) => item.usuario == getNombre || itwem.email == getEmail
    );
    if (usuario){
      alertaError("Error", "Usuario ya existe", "error");
    } else {
      fetch(apiUsuarios, {
        method: "POST",
        body: JSON.stringify({
          nombre: getNombre,
          apellido: getApellido,
          email: getEmail,
          password: getPassword,
        }),
      }).then(() => {
        console.log("Usuario registrado");
        getUsuarios();
      })
    }
  }

  return (
    <div className="container">
      <input id="signup_toggle" type="checkbox" />
      <form className="form">
        <div className="form_front">
          <div className="form_details">Login</div>
          <input onChange={(e) => setNombre(e.target.value)} type="text" className="input" placeholder="Nombre" />
          <input onChange={(e) => setPassword(e.target.value)} type="text" className="input" placeholder="Password" />
          <button type='button' onClick={iniciarSesion} className="btn">Login</button>
          <span className="switch">Don't have an account?
            <label for="signup_toggle" className="signup_tog">
              Sign Up
            </label>
          </span>
        </div>
        <div className="form_back">
          <div className="form_details">SignUp</div>
          <input onChange={(e) => setNombre(e.target.value)} type="text" className="input" placeholder="Nombre" />
          <input onChange={(e) => setApellido(e.target.value)} type="text" className="input" placeholder="Apellido" />
          <input onChange={(e) => setEmail(e.target.value)} type="text" className="input" placeholder="Email" />
          <input onChange={(e) => setPassword(e.target.value)} type="text" className="input" placeholder="Password" />
          <button type="button" onClick={registrarUsuario} className="btn">Signup</button>
          <span className="switch">Already have an account?
            <label for="signup_toggle" className="signup_tog">
              Sign In
            </label>
          </span>
        </div>
      </form>
    </div>
  )
}

export default Login