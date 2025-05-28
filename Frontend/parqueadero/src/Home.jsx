import './Home.css';
import Contenido from './components/Contenido.jsx';
import MenuLateral from './components/MenuLateral.jsx';
import { Outlet } from 'react-router-dom';

const Home = () => {
  return (
    <div className="aplicacion">
      <MenuLateral />
      <div className="aplicacion__contenido">
        <div className="aplicacion__contenido-fondo"></div>
        <main className="aplicacion__principal">
          <section className="aplicacion__eslogan">
            <h2 className="aplicacion__eslogan-texto">
              <span>Parqueadero</span>
            </h2>
          </section>

          <Contenido /> {/* Contenido general para todos */}
          
          <Outlet /> {/* Aquí se renderizan las páginas hijas como Cuenta, ReservasEspacio, etc. */}
        </main>
      </div>
    </div>
  );
};

export default Home;
