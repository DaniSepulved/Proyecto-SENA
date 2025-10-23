import './Home.css';
import Contenido from './components/Contenido.jsx';
import MenuLateral from './components/MenuLateral.jsx';
import { Outlet } from 'react-router-dom';
import ChatBotWidget from './components/ChatBotWidget';
import Footer from './components/Footer';

const Home = () => {
  return (
  <>
    <div className="aplicacion">
      <MenuLateral />
      <div className="aplicacion__contenido">
        <div className="aplicacion__contenido-fondo"></div>
        <main className="aplicacion__principal">
          <section className="aplicacion__eslogan">
            <h2 className="aplicacion__eslogan-texto">
              <span>ParqueaderoSC</span>
            </h2>
          </section>
          <section className="mvv">
              <h2 className="mvv__titulo">Nuestra Esencia</h2>
              <div className="mvv__cards">
                <div className="mvv__card">
                  <h3 className="mvv__card-titulo">Misión</h3>
                  <p className="mvv__card-texto">
                    Brindar a nuestros clientes un servicio de parqueadero seguro, ágil y confiable, 
                    garantizando comodidad y atención de calidad, con un compromiso constante hacia la innovación 
                    y la satisfacción del usuario.
                  </p>
                </div>

                <div className="mvv__card">
                  <h3 className="mvv__card-titulo">Visión</h3>
                  <p className="mvv__card-texto">
                    Ser el parqueadero líder en la región por nuestra eficiencia, 
                    tecnología avanzada y atención excepcional, contribuyendo a la movilidad urbana 
                    de forma sostenible y moderna.
                  </p>
                </div>

                <div className="mvv__card">
                  <h3 className="mvv__card-titulo">Valores</h3>
                  <ul className="mvv__valores-lista">
                    <li>✅ Responsabilidad</li>
                    <li>🤝 Compromiso</li>
                    <li>💡 Innovación</li>
                    <li>🛡️ Seguridad</li>
                    <li>🌱 Sostenibilidad</li>
                  </ul>
                </div>
              </div>
            </section>

          <Contenido /> 

          <Outlet /> {/* Aquí se renderizan las páginas hijas como Cuenta, ReservasEspacio, etc. */}
        </main>
      </div>
    </div>
    <ChatBotWidget /> 
    <Footer />
  </>
  );
};

export default Home;
