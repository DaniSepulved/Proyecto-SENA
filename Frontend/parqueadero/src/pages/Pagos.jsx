import { Form, useNavigate } from 'react-router-dom'
import "./Login.css"
import { alertaRedireccion, alertaError } from '../helpers/funciones'
// let apiPagos = "http://localhost:8080/api/pagos"

const Pagos = ()=>{
    return(
        <form action="">
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
        </form>
    )
}

export default Pagos